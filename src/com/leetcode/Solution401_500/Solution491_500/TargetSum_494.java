package com.leetcode.Solution401_500.Solution491_500;

/**
 * 目标和
 *
 * @author jianghan
 * @date 2021-01-14 10:40
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        //dp[i][j] 表示 取出nums[i]之前包括nums[i]个数,其和为j-1000的解法的个数
        //由于java中数组下标不能为负数,所以统一加上1000(题目给出的最大和)
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    //dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
                    //令J = sum + nums[i] + 1000 ,带入上式,这一步单纯的是代数计算,如果不好理解可以把上式拆成2个等式分别做if处理
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public static void main(String[] args) {
        TargetSum_494 targetSum_494 = new TargetSum_494();
        targetSum_494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
