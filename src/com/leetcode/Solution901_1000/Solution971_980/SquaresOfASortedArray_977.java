package com.leetcode.Solution901_1000.Solution971_980;

/**
 * 有序数组的平方
 *
 * @author jianghan
 * @date 2020-10-16 00:24
 */
public class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        //递增数列正负分界点 mid 为最接近0的负数下标
        int mid = -1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (A[i] < 0) {
                mid = i;
            } else {
                break;
            }
        }
        int index = 0;
        int left = mid;
        int right = mid + 1;
        while (left >= 0 || right < length) {
            //非负递增数列
            if (left < 0) {
                result[index] = A[right] * A[right];
                right++;
            } else if (right == length) {
                result[index] = A[left] * A[left];
                left--;
            } else if (A[left] * -1 <= A[right]) {
                result[index] = A[left] * A[left];
                left--;
            } else if (A[left] * -1 > A[right]) {
                result[index] = A[right] * A[right];
                right++;
            }
            index++;
        }
        return result;
    }
}
