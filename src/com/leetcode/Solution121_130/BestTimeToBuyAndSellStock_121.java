package com.leetcode.Solution121_130;

/**
 * 买卖股票的最佳时机
 *
 * @author jianghanh
 * @date 2020-03-09 00:47
 */
public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        return forceSearch(prices);
    }

    /**
     * 暴力法
     */
    private int forceSearch(int[] prices){
        int res = 0;
        for(int i = 0 ;i<prices.length;i++){
            for(int j = i+1 ;j<prices.length;j++){
                res = Math.max(prices[j]-prices[i],res);
            }
        }
        return res;
    }
}
