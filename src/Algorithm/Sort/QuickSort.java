package Algorithm.Sort;


/**
 * 快速排序 不稳定的排序
 * 平均时间复杂度O(n log n)  【O(logN),O(n^2)】
 * <p>
 * 快速排序的核心思想非常简单就是递归
 * 通过确定基准数的位置将数组分隔为两个部分,再对这两个部分再进行确定基准数的排序,直至排序完成
 * 所以问题就转化成如何确认这个基准数在数组中的位置
 * 详情见代码中的注释
 *
 * @author jianghan
 * @date 2021-02-24 01:25
 */
public class QuickSort {

    //快速排序是 【原地】地进行排序,且分别会对左右数组进行递归,所以标准的三个参数
    public void quick_sort(int[] array, int left, int right) {
        //递归出口 这里不能写 left == right 理由后面解释(1)
        if (left > right) {
            return;
        }
        //通常 我们以最左边的的数作为基准数
        int base = array[left];
        //定义左右两个指针 分别指向数组的两端
        int i = left;
        int j = right;
        //当两个指针不相遇的时候,我们对该数组进行检索
        while (i != j) {
            //以左边为基准数,就要优先从右边开始检索,找到右边第一个比base小的数停止
            //为什么要从右边开始,后面有解释(2)
            while (array[j] >= base && i < j) {
                j--;
            }
            //再从左边开始检索,找到左边第一个比base大的数停止
            while (array[i] <= base && i < j) {
                i++;
            }
            //找到这两个数的索引,交换这两个数的位置
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        //两个指针相遇了,我们交换base和相遇索引对应的值
        //这一步操作保证了此时 base位置的左边都小于base,右边都大于base
        //为什么能保证上述结论的成立?原因就是 (2) 这个地方优先从右边开始检索
        //由于先移动的是右边的指针,相遇或者比基准数小才会停下,一旦相遇又代表上一次检索中左指针和右指针进行过交换 所以肯定也比基准数小
        //好了 我们交换两个值
        array[left] = array[i];
        array[i] = base;
        //现在左边都比base小,右边都比base大
        //我们让左右两边都递归的调用,直到left > right 递归结束,数组也就排好了
        //这里的i-1和i+1 解释了(1) 这个地方不能用left == right做出口的原因,两个数不一定会相遇,如果不相遇就索引越界了
        quick_sort(array, left, i - 1);
        quick_sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{6, 2, 3, 7, 1, 4, 9, 0, 5, 8};
        quickSort.quick_sort(array, 0, 9);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }
}
