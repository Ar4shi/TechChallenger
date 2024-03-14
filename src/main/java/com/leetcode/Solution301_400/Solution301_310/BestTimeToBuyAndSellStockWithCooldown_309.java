package com.leetcode.Solution301_400.Solution301_310;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author jianghan
 * @date 2021-01-25 00:58
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        //dp[a][b][c]表示第a天交易状态为b且持股状态为c的情况下的最大利润
        int[][][] dp = new int[prices.length][4][2];
        //初始化 0按兵不动 1买入 2卖出 3冷冻期
        dp[0][0][0] = 0;
        //第一天按兵不动却持股不可能
        dp[0][0][1] = Integer.MIN_VALUE;
        //第一天买入且不持股也不可能
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        //第一天卖出且持股 不可能
        dp[0][2][1] = Integer.MIN_VALUE;
        //第一天就不可能冷冻期
        dp[0][3][0] = 0;
        dp[0][3][1] = 0;
        //套模板
        //由于第二层循环的次数固定且比较少,我们直接写
        for (int i = 1; i < prices.length; i++) {
            //按兵不动的前一天可能是任何状态下的 买入 或者 冷冻期 或者同样 按兵不动
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][3][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][1]);
            //买入的前一天只可能是不持股状态下的按兵不动或者冷冻期
            dp[i][1][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][3][0] - prices[i]);
            //卖出的前一天只可能是持股状态下的按兵不动或者买入
            dp[i][2][0] = Math.max(dp[i - 1][0][1] + prices[i], dp[i - 1][1][1] + prices[i]);
            //冷冻期的前一天必为持股状态的卖出
            dp[i][3][0] = dp[i - 1][2][0];
        }
        //最大值肯定在按兵不动和卖出和冷冻期三者之间
        return Math.max(Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][2][0]),Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][3][0]));
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown_309 bestTimeToBuyAndSellStockWithCooldown_309 = new BestTimeToBuyAndSellStockWithCooldown_309();
        bestTimeToBuyAndSellStockWithCooldown_309.maxProfit(new int[]{1, 4, 2});
    }
}
