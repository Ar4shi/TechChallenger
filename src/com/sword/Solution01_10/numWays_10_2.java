package com.sword.Solution01_10;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * @author jianghan
 * @date 2021-03-21 00:42
 */
public class numWays_10_2 {

    //f(n) = f(n-1) + f(n-2)
    public int numWays(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
