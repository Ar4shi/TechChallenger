package Algorithm.Sort;

/**
 * 冒泡 排序
 * 稳定的排序
 * 时间复杂度 O(n^2)
 *
 * @author jianghan
 * @date 2021-02-27 23:50
 */
public class BubbleSort {

    /**
     * 冒泡排序是【原地】地进行排序
     * 主要思路是通过不停地比较相邻的两个数的大小,使得较大的那个数往数组的末端移动
     * 这个过程就好像泡泡上浮由于水压变低越来越大一样,所以称为冒泡排序
     * 通过不停的循环冒泡每次都能使大数上浮直到扫描到唯一的元素不需要上浮排序也就完成了
     */
    public void bubble_sort(int[] array) {
        //优化点1 N个数循环N-1次就够了
        for (int i = 0; i < array.length - 1; i++) {
            //优化点2 由于每一次排序后,最大的数都会上浮到对应的位置
            //所以每次循环都可以节约相应的比对次数,比对过程会越来越少
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{6, 2, 3, 7, 1, 4, 9, 0, 5, 8};
        bubbleSort.bubble_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }
}
