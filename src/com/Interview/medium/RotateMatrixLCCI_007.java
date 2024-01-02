package com.Interview.medium;

public class RotateMatrixLCCI_007 {

    public void rotate(int[][] matrix) {
        int[][] newArray = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // 找规律.遇到矩阵旋转先看 length 、 i 、j 之间的规律,不要先去想什么对角线中心对称什么的
                newArray[j][matrix.length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = newArray[i][j];
            }
        }
    }
}
