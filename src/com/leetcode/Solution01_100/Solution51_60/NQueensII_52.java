package com.leetcode.Solution01_100.Solution51_60;

import java.util.Arrays;

/**
 * N皇后 II
 *
 * @author jianghan
 * @date 2020-10-17 15:18
 */
public class NQueensII_52 {
    int n;
    int res = 0;

    public int totalNQueens(int n) {
        this.n = n;
        recursion(new int[n][n], 0);
        return res;
    }

    private void recursion(int[][] dp, int row) {
        if (row == n) {
            res += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (dp[row][i] == 0) {
                //记录棋盘初始状态用于回溯
                int[][] dpCopy = new int[n][n];
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        dpCopy[k][l] = dp[k][l];
                    }
                }
                //纵横不可再选
                for (int j = 0; j < n; j++) {
                    dp[row][j] = 1;
                    dp[j][i] = 1;
                }
                //对角线不可再选
                int nextRow = row + 1;
                int nextCol = i + 1;
                while (nextRow < n && nextCol < n) {
                    dp[nextRow][nextCol] = 1;
                    nextRow++;
                    nextCol++;
                }
                nextRow = row + 1;
                nextCol = i - 1;
                while (nextRow < n && nextCol > -1) {
                    dp[nextRow][nextCol] = 1;
                    nextRow++;
                    nextCol--;
                }
                for (int x = 0; x < n; x++) {
                    System.out.println(Arrays.toString(dp[x]));
                }
                System.out.println("---------------------");
                row++;
                recursion(dp, row);
                //回溯
                row--;
                dp = dpCopy;
                for (int x = 0; x < n; x++) {
                    System.out.println(Arrays.toString(dp[x]));
                }
                System.out.println("---------------------");
            }
        }
    }

    public static void main(String[] args) {
        NQueensII_52 nQueensII_52 = new NQueensII_52();
        nQueensII_52.totalNQueens(4);
    }
}
