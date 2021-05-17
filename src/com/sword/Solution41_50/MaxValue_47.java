package com.sword.Solution41_50;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * @author jianghan
 * @date 2021-05-15 17:00
 */
public class MaxValue_47 {
    public int maxValue(int[][] grid) {
        //dp[i][j] 代表当取数到达 i j 对应坐标所能获取的最大价值
        //dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j])
        int[][] dp = new int[grid.length][grid[0].length];
        //initialize dp
        dp[0][0] = grid[0][0];
        //dp遍历模板
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MaxValue_47 maxValue_47 = new MaxValue_47();
        System.out.println(maxValue_47.maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}}));
    }
}
