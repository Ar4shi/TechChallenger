package com.sword.Solution11_20;

/**
 * 剑指 Offer 14- I. 剪绳子
 *
 * @author jianghan
 * @date 2021-03-21 21:54
 */
public class CuttingRope_14_1 {

    //最简单的一维dp
    public int cuttingRope(int n) {
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

    public static void main(String[] args) {
        CuttingRope_14_1 cuttingRope_14_1 = new CuttingRope_14_1();
        System.out.println(cuttingRope_14_1.cuttingRope(10));
    }
}
