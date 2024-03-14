package com.leetcode.Solution301_400.Solution331_340;

/**
 * 递增的三元子序列
 *
 * @author jianghan
 * @date 2022-01-12 01:14
 */
public class IncreasingTripletSubsequence_334 {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < leftMin.length - 1; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        for (int i = nums.length - 2; i > 1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 超时
     * 可以考虑把结果存到数组 👆
     */
    public boolean increasingTriplet_timeOut(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (findMin(i, nums) < nums[i] && findMax(i, nums) > nums[i]) {
                return true;
            }
        }
        return false;
    }

    private int findMin(int right, int[] nums) {
        int min = nums[0];
        for (int i = 1; i < right; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    private int findMax(int left, int[] nums) {
        int max = nums[left + 1];
        for (int i = left + 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
