package com.interview.medium;


/**
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 示例1:
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * <p>
 * 示例2:
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 * <p>
 * 提示:
 * arr 长度范围在[1, 1000000]之间
 */
public class SearchRotateArray {

    public int search(int[] arr, int target) {
        // 这个点会把数组切割为左右两个递增的数组,但是并不意味着左边的数组一定比右边数组大
        int rotateIndex = getRotateIndex(arr);
        if (target == arr[rotateIndex]) {
            return rotateIndex;
        }
        int suspect1 = binarySearch(arr, 0, rotateIndex - 1, target);
        int suspect2 = binarySearch(arr, rotateIndex + 1, arr.length - 1, target);
        if (suspect1 != -1) {
            return suspect1;
        }
        if (suspect2 != -1) {
            return suspect2;
        }
        return -1;
    }

    private int getRotateIndex(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) {
            return 0;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
