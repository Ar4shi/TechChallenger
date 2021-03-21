package com.leetcode.Solution201_300.Solution231_240;

/**
 * 搜索二维矩阵 II
 * 同剑指offer FindNumberIn2DArray_04
 *
 * @author jianghan
 * @date 2021-03-21 23:11
 */
public class SearchA2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            int node = matrix[i][0];
            if (node > target) {
                return false;
            }
            int j = 0;
            while (j < matrix[i].length && matrix[i][j] < target) {
                j++;
            }
            if (j < matrix[i].length && matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
