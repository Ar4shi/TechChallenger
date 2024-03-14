package com.leetcode.Solution101_200.Solution181_190;

/**
 * 买卖股票的最佳时机 IV
 *
 * @author jianghan
 * @date 2021-01-24 17:53
 */
public class BestTimeToBuyAndSellStockIV_188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        //dp[a][b][c] 代表 前a天且已完成b次交易,目前手中股票状态为c所获+取的最大利润
        int[][][] dp = new int[prices.length][k + 1][2];
        //初始化第一天的情况
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        //套模板遍历
        //由于第三层遍历 长度固定且很短 可以和上面初始化一样简写在第二层里
        //第三层 for (int m = 0; m < k; m++)
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0) {
                    //未进行交易且不持有股票利润必为0
                    dp[i][0][0] = 0;
                } else {
                    //不持有股票的情况：1、前一天就不曾持有 2、今天把股票卖了
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }
                //持有股票的情况: 1、前一天就持有 2、今天买了一只新股
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        return getMax(k, dp);
    }

    //获取DP的最大值
    private int getMax(int k, int[][][] dp) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < k + 1; i++) {
            max = Math.max(dp[dp.length - 1][i][0], max);
        }
        return max;
    }
}
