package com.leetcode.Solution01_100.Solution71_80;

/**
 * 爬楼梯
 *
 * @author jianghan
 * @date 2020-09-17 01:19
 */
public class ClimbingStairs_70 {
    int count = 0;

    //动态规划
    //第N级台阶f(n)可以理解为第N-1级台阶跳一级上来f(n-1) + 第N-2级台阶跳两级上来f(n-2)
    //无论跳一级还是跳两级上来 其实在n-1和n-2级台阶的时候已经确定了,所以不必+常数
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


    //递归 超时
    public int climbStairs1(int n) {
        if (n == 0) return 0;
        recursion(n);
        return count;
    }

    //递归 超时
    private void recursion(int n) {
        if (n == 0) {
            count += 1;
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i = 1; i <= 2; i++) {
            recursion(n - i);
        }
    }
}
