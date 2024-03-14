package com.leetcode.Solution901_1000.Solution971_980;

import java.util.Arrays;

/**
 * 三角形的最大周长
 *
 * @author jianghan
 * @date 2020-11-29 16:26
 */
public class LargestPerimeterTriangle_976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
