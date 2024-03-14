package com.leetcode.Solution01_100.Solution61_70;

/**
 * 不同路径
 *
 * @author jianghan
 * @date 2020-09-19 14:52
 */
public class UniquePaths_62 {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        if (m == 1 || n == 1) {
            return 1;
        }
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        dp(m, n);
        return dp[m - 1][n - 1];
    }

    //dp[i][j] = dp[i][j-1] + dp[i-1][j]
    private void dp(int m, int n) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
    }
}
