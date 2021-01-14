package com.leetcode.Solution401_500.Solution491_500;

/**
 * 目标和
 *
 * @author jianghan
 * @date 2021-01-14 10:40
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        //dp[i][j] 表示取nums的前i位,能组合成数字j的方案数
        int[][] dp = new int[nums.length + 1][2001];
        dp[1][nums[0] + 1000] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = -1000; j <= 1000; j++) {
                //和走楼梯那个逻辑差不多
                //dp[i][j + 1000] = dp[i - 1][j - nums[i] + 1000] + dp[i - 1][j + nums[i] + 1000];
                if (j - nums[i] > 1000) {
                    dp[i][j + 1000] = dp[i - 1][j - nums[i] + 1000];
                }
                if (j + nums[i] < 2000) {
                    dp[i][j + 1000] += dp[i - 1][j + nums[i] + 1000];
                }

            }
        }
        return dp[nums.length][S + 1000];
    }

    public static void main(String[] args) {
        TargetSum_494 targetSum_494 = new TargetSum_494();
        targetSum_494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
