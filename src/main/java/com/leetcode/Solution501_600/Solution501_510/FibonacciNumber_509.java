package com.leetcode.Solution501_600.Solution501_510;

/**
 * 斐波那契数
 *
 * @author jianghan
 * @date 2021-01-04 00:41
 */
public class FibonacciNumber_509 {
    int[] dp;

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        this.dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
