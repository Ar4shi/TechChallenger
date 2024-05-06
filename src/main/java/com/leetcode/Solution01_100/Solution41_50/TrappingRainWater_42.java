package com.leetcode.Solution01_100.Solution41_50;

import java.util.Stack;

/**
 * 接雨水
 *
 * @author jianghan
 * @date 2020-09-16 23:25
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        return monotonicStack(height);
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
        int result = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        while (left <= right) {
            if (leftMax < rightMax) {
                if (leftMax > height[left]) {
                    result += leftMax - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                if (rightMax > height[right]) {
                    result += rightMax - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }

    /**
     * 横向计算
     * 单调栈
     */
    private int monotonicStack(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int preIndex = stack.peek();
                // 高度差 = min(当前柱子高度,前前柱子高度) - 之前柱子高度
                int heightDiff = Math.min(height[i], height[preIndex]) - height[index];
                int widthDiff = i - preIndex - 1;
                result += heightDiff * widthDiff;
            }
            stack.add(i);
        }
        return result;
    }
}
