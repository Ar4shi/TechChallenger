package Algorithm.Sort;

/**
 * 冒泡排序
 * 稳定的排序
 * 时间复杂度 O(n^2)
 *
 * @author jianghan
 * @date 2021-02-27 23:50
 */
public class BubbleSort {

    public void bubble_sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
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
