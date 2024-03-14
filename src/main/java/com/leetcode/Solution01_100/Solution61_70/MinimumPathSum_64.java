package com.leetcode.Solution01_100.Solution61_70;

/**
 * 最小路径和
 *
 * @author jianghan
 * @date 2020-09-20 01:52
 */
public class MinimumPathSum_64 {
    int[][] dp;
    int[][] grid;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        this.grid = grid;
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        dp();
        return dp[grid.length - 1][grid[0].length - 1];
    }

    private void dp() {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
    }

}
