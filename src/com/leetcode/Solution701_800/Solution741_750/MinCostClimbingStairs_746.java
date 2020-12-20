package com.leetcode.Solution701_800.Solution741_750;

/**
 * 使用最小花费爬楼梯
 *
 * @author jianghan
 * @date 2020-12-21 00:16
 */
public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1){
            return cost[0];
        }
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        //f(n) = cost(n) + min{f(n-1),f(n-2)}
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 2],dp[cost.length - 1]);
    }
}
