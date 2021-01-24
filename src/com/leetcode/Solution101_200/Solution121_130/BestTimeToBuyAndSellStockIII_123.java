package com.leetcode.Solution101_200.Solution121_130;

/**
 * 买卖股票的最佳时机 III
 *
 * @author jianghan
 * @date 2021-01-24 01:30
 */
public class BestTimeToBuyAndSellStockIII_123 {
    public int maxProfit(int[] prices) {
        //dp[a][b][c] 代表 前a天且已完成b次交易,目前手中股票状态为c所获+取的最大利润
        int[][][] dp = new int[prices.length][3][2];
        //初始化第一天的情况
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        //按题意允许当天买入再卖出 所以下面的情况也需要初始化
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        //套模板遍历
        //由于第二层遍历和第三层遍历 长度固定且很短 可以和上面初始化一样简写在第一层里
        //第二层 for (int j = 0; j < 3; j++)
        //第三层 for (int k = 0; k < 2; k++)
        for (int i = 1; i < prices.length; i++) {
            //未进行交易且不持有股票利润必为0
            dp[i][0][0] = 0;
            //持有股票的情况: 1、前一天就持有 2、今天买了一只新股
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            //不持有股票的情况：1、前一天就不曾持有 2、今天把股票卖了
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            //已经交易了两次手里还持有股票必不可能利润最大甚至可以直接给一个整型最小值
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][2][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][2][0], dp[prices.length - 1][1][0]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII_123 bestTimeToBuyAndSellStockIII_123 = new BestTimeToBuyAndSellStockIII_123();
        bestTimeToBuyAndSellStockIII_123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }
}
