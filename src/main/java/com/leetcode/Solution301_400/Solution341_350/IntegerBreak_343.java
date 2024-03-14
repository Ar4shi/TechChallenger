package com.leetcode.Solution301_400.Solution341_350;

/**
 * 整数拆分
 *
 * @author jianghan
 * @date 2021-03-21 22:32
 */
public class IntegerBreak_343 {
    //这题和剑指offer剪绳子I那道题一样
    //直接搬过来了 但是这种解法只能支撑n比较小的情况
    //时间复杂度O(n^2)
    //n很大的话还是要用贪心 详情见 CuttingRope_14_2
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            //j代表剪一刀可能的长度 1没有意义 所以从2开始计算
            for (int j = 2; j < i; j++) {
                //                            ↓只剪一刀乘积
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
                //                                          ↑不只剪一刀用本次的长度*之前的最大值
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
