package com.leetcode.Solution01_100.Solution51_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 *
 * @author jianghan
 * @date 2020-10-18 00:42
 */
public class NQueens_51 {
    int n;
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        recursion(new int[n][n], 0, new String[n][n]);
        return res;
    }

    private void recursion(int[][] dp, int row, String[][] strArray) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    if (strArray[i][j] == null) {
                        str += ".";
                    } else {
                        str += strArray[i][j];
                    }
                }
                list.add(str);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (dp[row][i] == 0) {
                strArray[row][i] = "Q";
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
                recursion(dp, row, strArray);
                //回溯
                row--;
                dp = dpCopy;
                strArray[row][i] = null;
                for (int x = 0; x < n; x++) {
                    System.out.println(Arrays.toString(dp[x]));
                }
                System.out.println("---------------------");
            }
        }
    }
}
