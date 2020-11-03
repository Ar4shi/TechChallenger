package com.leetcode.Solution901_1000.Solution941_950;

/**
 * 有效的山脉数组
 *
 * @author jianghan
 * @date 2020-11-03 15:41
 */
public class ValidMountainArray_941 {
    public boolean validMountainArray(int[] A) {
        boolean result = true;
        boolean isRise = true;
        if (A.length < 3 || A[0] >= A[1]) {
            return false;
        }
        for (int i = 0; i < A.length - 1; i++) {
            int front = A[i];
            int behind = A[i + 1];
            if (front == behind) {
                result = false;
                break;
            }
            if (isRise) {
                if (front > behind) {
                    isRise = false;
                }
            } else {
                if (front < behind) {
                    result = false;
                    break;
                }
            }
        }
        if (isRise) {
            result = false;
        }
        return result;
    }
}
