package com.leetcode.Solution301_400.Solution321_330;

/**
 * 零钱兑换
 *
 * @author jianghan
 * @date 2021-01-12 01:54
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        //完全背包问题
        //dp[i][j] 代表取前i种硬币,能够达成金额j所需的最少硬币数
        //dp[i][j] = dp[i-1][j] coins[i-1]>j
        //dp[i][j] = min{dp[i-1][j],dp[i][j-coins[]]+1}
        //                             ↑ 这个地方就是和01背包的区别 01背包要么放要么不放,所以是i-1和上一行比较
        //                                完全背包可以放多个,所以是i和同一行的前列去比较
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0;i<coins.length+1;i++){
            for(int j = 0;j<amount+1;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化 取第一个硬币,达成金额为第一个硬币的金额,所需硬币数量为1
        dp[1][coins[0]] = 1;
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = coins[0]; j <= amount; j++) {
                //取前i个硬币,对应的coins的下标是i-1
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange_322 coinChange_322 = new CoinChange_322();
        coinChange_322.coinChange(new int[]{1, 2, 5}, 11);
    }
}
