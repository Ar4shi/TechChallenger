package com.interview.medium;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * <p>
 * [1,   4,  7, 11, 15],
 * <p>
 * [2,   5,  8, 12, 19],
 * <p>
 * [3,   6,  9, 16, 22],
 * <p>
 * [10, 13, 14, 17, 24],
 * <p>
 * [18, 21, 23, 26, 30]
 * <p>
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class SortedMatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                return false;
            }
            if (matrix[i][0] > target || matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
