package Algorithm.Sort;

/**
 * 堆排序
 * 平均时间复杂度O(nLogN)
 * 不稳定
 * 【原地】地进行排序
 * <p>
 * 由于堆本身是一颗完全二叉树,所以其每一个节点都可以通过索引计算出来
 * 所以堆的逻辑结构是数 存储结构可以是数组(下标计算)
 * <p>
 * 对于任意一个堆的任意一个节点,假设下标为i
 * parent = (i-1)/2
 * leftChild = 2i+1
 * rightChild = 2i+2
 * <p>
 * 堆排序的基本思路
 * 1、将数组初始化成一棵大(小)顶堆 initializeHeap
 * 2、交换顶部元素与尾部元素的位置,并切断尾部元素,对数组的剩余元素继续堆化heapify
 * 3、循环地进行操作【2】直到数组中没有值
 * 4、此时数组就已经从小(大)到大排列了
 *
 * @author jianghan
 * @date 2021-02-26 01:28
 */
public class HeapSort {

    public void heap_sort(int[] array) {
        //1、初始化
        initializeHeap(array);
        //3、循环地进行操作【2】直到数组中没有值
        for (int i = array.length - 1; i >= 0; i--) {
            //2、交换顶部元素与尾部元素的位置,并切断尾部元素,对数组的剩余元素继续堆化heapify
            swap(array, i, 0);
            //由于只是交换了堆头尾地位置,所以不需要像初始化一样繁琐地对每个根节点进行堆化
            //只需要对头节点进行堆化即可
            heapify(array, 0, i + 1);
        }
    }

    /**
     * 初始化大(小)顶堆
     */
    private void initializeHeap(int[] array) {
        int length = array.length;
        int lastNodeIndex = length - 1;
        //套公式计算最后一个根节点的索引
        int lastParent = (lastNodeIndex - 1) >> 1;
        //堆每个节点进行堆化
        for (int i = lastParent; i >= 0; i--) {
            heapify(array, i, length);
        }
    }

    /**
     * 将数组堆化,并不是初始化,初始化需要重复调用这个过程
     */
    private void heapify(int[] array, int i, int length) {
        //其实可以不需要这个出口
        //left < length 和 right < length其实已经包含了这个出口了
        //还是写了这个条件算是个习惯,递归出口前置总没有错
        if (i >= length) {
            return;
        }
        //最大值索引默认为i
        int max = i;
        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        //计算三个数最大值的下标
        if (left < length && array[left] > max) {
            max = left;
        }
        if (right < length && array[right] > max) {
            max = right;
        }
        if (max != i) {
            //此时将最大值移到堆顶
            swap(array, i, max);
            //由于交换了位置,导致堆结构崩坏,所以要对交换位置的节点继续递归堆化
            heapify(array, max, length);
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{6, 2, 3, 7, 1, 4, 9, 0, 5, 8};
        heapSort.heap_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
        }
    }
}

