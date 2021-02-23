package com.leetcode.Solution801_900.Solution831_840;

import java.util.Stack;

/**
 * 翻转图像
 *
 * @author jianghan
 * @date 2021-02-24 00:28
 */
public class FlippingAnImage_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < A[i].length; j++) {
                stack.push(A[i][j] == 0 ? 1 : 0);
            }
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = stack.pop();
            }
        }
        return A;
    }
}
