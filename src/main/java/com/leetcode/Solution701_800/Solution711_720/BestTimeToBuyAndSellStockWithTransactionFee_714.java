package com.leetcode.Solution701_800.Solution711_720;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author jianghan
 * @date 2021-01-26 00:24
 */
public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        //dp[a][b][c]表示第a天交易状态为b且持股状态为c的情况下的最大利润
        int[][][] dp = new int[prices.length][3][2];
        //初始化 0按兵不动 1买入 2卖出
        dp[0][0][0] = 0;
        //第一天按兵不动却持股是可能的 和冷冻期那道题有区别
        dp[0][0][1] = -prices[0];
        //第一天买入且不持股也不可能
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = -fee;
        //第一天卖出且持股 不可能
        dp[0][2][1] = Integer.MIN_VALUE;
        //套模板
        //由于第二层循环的次数固定且比较少,我们直接写
        for (int i = 1; i < prices.length; i++) {
            //按兵不动的前一天可能是任何状态下的 买入 或者同样 按兵不动 或者卖出
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][2][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
            //买入的前一天只可能是不持股状态下的按兵不动或者不持股状态下的卖出
            dp[i][1][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][2][0] - prices[i]);
            //卖出的前一天只可能是持股状态下的按兵不动或者买入
            dp[i][2][0] = Math.max(dp[i - 1][0][1] + prices[i] - fee, dp[i - 1][1][1] + prices[i] - fee);
        }
        //最大值肯定在按兵不动和卖出两者之间
        return Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][2][0]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee_714 bestTimeToBuyAndSellStockWithTransactionFee_714 = new BestTimeToBuyAndSellStockWithTransactionFee_714();
        bestTimeToBuyAndSellStockWithTransactionFee_714.maxProfit(new int[]{1, 1, 1, 3, 5, 2, 5, 4, 3, 2}, 4);
    }
}
