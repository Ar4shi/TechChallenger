package com.leetcode.Solution01_100.Solution51_60;

/**
 * 跳跃游戏
 *
 * @author jianghan
 * @date 2020-09-14 00:59
 */
public class JumpGame_55 {
    boolean result = false;
    int[] nums;

    public boolean canJump(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLength) {
                return false;
            }
            maxLength = Math.max(maxLength, i + nums[i]);
        }
        return true;
    }

    //超时
    public boolean canJump2(int[] nums) {
        this.nums = nums;
        recursion(0, nums[0]);
        return result;
    }

    //超时
    private void recursion(int current, int step) {
        if (result || current == nums.length - 1) {
            result = true;
        }
        for (int i = 1; i <= step; i++) {
            if (current + i < nums.length) {
                recursion(current + i, nums[current + i]);
            }
        }
    }
}
