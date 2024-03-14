package Algorithm.Sort;

/**
 * 选择排序
 * O(n^2)
 * 也是【原地】地排序
 * 简而言之就是找到最小的数放开头,然后一遍一遍地找
 * 扫描完后就排好了
 *
 * @author jianghan
 * @date 2021-03-07 21:53
 */
public class SelectionSort {
    public void selection_sort(int[] array) {
        int minIndex = 0;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            minIndex = 0;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = new int[]{6, 2, 3, 7, 1, 4, 9, 0, 5, 8};
        selectionSort.selection_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }
}
