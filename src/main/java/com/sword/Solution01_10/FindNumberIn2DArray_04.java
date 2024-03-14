package com.sword.Solution01_10;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * @author jianghan
 * @date 2021-03-20 00:58
 */
public class FindNumberIn2DArray_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
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
