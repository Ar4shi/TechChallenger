package com.leetcode.Solution01_100.Solution41_50;

/**
 * 接雨水
 *
 * @author jianghan
 * @date 2020-09-16 23:25
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        return basicSolution(height);
    }

    /**
     * 纵向计算
     * 计算每个索引所在位置能装多少水
     * 当前索引位置能装的水 = min(左边最高的柱子,右边最高的柱子) - 当前柱子的高度
     */
    private int basicSolution(int[] height) {
        int result = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                maxLeft[i] = height[i];
                continue;
            }
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                maxRight[i] = height[i];
                continue;
            }
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i - 1], maxRight[i + 1]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }

    /**
     * 双指针
     * 优化方法一的空间复杂度
     * 观察到方法一中的maxLeft和maxRight数组可以通过双指针的方式来维护,即只要保存左右两边的最大值
     */
    private int twoPointer(int[] height) {
        return 0;
    }

    /**
     * 横向计算
     * 单调栈
     */
    private int monotonicStack(int[] height) {
        return 0;
    }
}
