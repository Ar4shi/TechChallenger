package com.interview.medium;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 说明：
 * 注意:
 * 你可以假设：
 * 0 <= n (总金额) <= 1000000
 */
public class Coin {

    static final int MOD = 1000000007;
    int[] coins = {25, 10, 5, 1};

    /**
     * 0,1 背包 + 完全背包
     */
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 以coin为最后一枚硬币，计算总金额为j的硬币组合数
        for (int i = 0; i < 4; i++) {
            int coin = coins[i];
            // 从coin开始，因为dp[j] = dp[j] + dp[j - coin]，dp[j - coin]表示的是上一轮的值
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }
        return dp[n];
    }
}
