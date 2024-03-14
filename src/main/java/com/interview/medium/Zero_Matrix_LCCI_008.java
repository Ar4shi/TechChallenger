package com.interview.medium;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */
public class Zero_Matrix_LCCI_008 {

    public void setZeroes(int[][] matrix) {
        // 映射一个一摸一样的矩阵
        int[][] auxiliaryMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                auxiliaryMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && auxiliaryMatrix[i][j] == 0) {
                    for (int a = 0; a < matrix.length; a++) {
                        matrix[a][j] = 0;
                    }
                    for (int a = 0; a < matrix[0].length; a++) {
                        matrix[i][a] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 1, 1}, {1, 0, 1,}, {1, 1, 1}};
        Zero_Matrix_LCCI_008 zero_matrix_lcci_008 = new Zero_Matrix_LCCI_008();
        zero_matrix_lcci_008.setZeroes(matrix);
    }
}
