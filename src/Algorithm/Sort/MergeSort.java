package Algorithm.Sort;

/**
 * 归并排序
 * 稳定性 稳定
 * 时间复杂度O(n log n)
 * 空间复杂度T（n)
 * <p>
 * 归并排序的基本思想是
 * 1、通过递归,把数组最终分隔成单个元素为一组的数组,此时每一组的元素都是有序的,毕竟只有一个元素了
 * 2、递归结束向上回溯,两两合并,保证合并过后的数组都是有序的,这一步会使用额外的内存空间,并且要把结果回写到原数组
 * 3、回溯完成也就代表了合并完成,此时数组便是有序的数组
 *
 * @author jianghan
 * @date 2020-11-29 20:41
 */
public class MergeSort {

    /**
     * 归(递归)
     * 归并排序和快速排序一样也是【原地】地进行排序,但是归并排序需要用到额外的物理内存空间
     * 两种排序的思想完全不同,归并属于分治法范畴,代码中可以清晰的体现出递归和合并的两个过程
     * 总体而言归并排序要稍微难写一点,对区间的开闭也更讲究
     * <p>
     * 归并由于使用了二分的思想,所以需要通过left和right来确定mid所以也是三个参数
     * 和快速排序一样,不过原因还是有所差异的
     */
    public void merge_sort(int[] array, int left, int right) {
        //递归的出口 此时就代表每一组都拆分成一个独立的元素了
        if (left >= right) {
            return;
        }
        //二分取索引的中心点,由于每次都是二分,所以才导致归并排序时间复杂度是稳定的而快排不稳定
        int mid = (left + right) >> 1;
        //继续拆分直到每组元素都唯一
        merge_sort(array, left, mid);
        merge_sort(array, mid + 1, right);
        //程序运行到这里其实有两种情况去理解
        //1、拆无可拆,都拆到原子了,那就要开始合并了
        //2、回溯到这个地方,也需要开始合并了
        //那就开始合并,合并要多一个参数,就是计算出的mid,需要mid这个参数来标识数组2开始索引的位置
        merge(array, left, right, mid);
    }

    //并(合并)
    private void merge(int[] array, int left, int right, int mid) {
        //需要一个额外的数组来存放排序好的数据,并在最后回写到源数组中
        int[] temp = new int[right - left + 1];
        //待排序的两部分数组的起始位置的索引
        int s1 = left;
        int s2 = mid + 1;
        //temp数组的索引
        int index = 0;
        //这个条件保证了左右两个数组中都有数据,如果有一个没有了那就可以直接填进temp了
        while (s1 <= mid && s2 <= right) {
            if (array[s1] <= array[s2]) {
                temp[index++] = array[s1++];
            } else {
                temp[index++] = array[s2++];
            }
        }
        //出来后,如果数组中还有元素,就全部塞进去
        while (s1 <= mid) {
            temp[index++] = array[s1++];
        }
        while (s2 <= right) {
            temp[index++] = array[s2++];
        }
        //把temp中的数据回写到源数组中
        for (int i = 0; i < right - left + 1; i++) {
            array[i + left] = temp[i];
        }
    }

    //总结一下,归并由于是分治法的一种实现,理解难度和实现难度都是>快速排序的
    //快排个人认为是通过【数学】程度上的思维对归并的一些弱点(二分导致时间复杂度绝对化了)进行了优化
    //同样快排也有在运气不好的情况下复杂度为O(n^2)的问题
    //归并更能体现出计算机算法的精巧,快排则更多的基于数学的思维
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{6, 2, 3, 7, 1, 4, 9, 0, 5, 8};
        mergeSort.merge_sort(array, 0, 9);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }
}
