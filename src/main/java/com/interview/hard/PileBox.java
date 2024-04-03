package com.interview.hard;

import java.util.Arrays;

/**
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * <p>
 * 示例2:
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * <p>
 * 提示:
 * 箱子的数目不大于3000个。
 */
public class PileBox {

    public int pileBox(int[][] box) {
        // 根据箱子的宽度进行排序
        Arrays.sort(box, (x, y) -> x[0] - y[0]);
        // dp[i]表示以第i个箱子为底的最高堆的高度
        int[] dp = new int[box.length];
        dp[0] = box[0][2];
        for (int i = 1; i < box.length; i++) {
            // 只有排在前面的箱子才有可能在当前的箱子上面
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    // 不能用dp[i] = Math.max(dp[i], dp[j] + box[i][2]),因为dp[j]可能是0,dp[j]为0代表第j个箱子不能放在第i个箱子上面
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += box[i][2];
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

}
