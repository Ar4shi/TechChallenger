package com.leetcode.Solution101_200.Solution191_200;

import java.util.Arrays;

/**
 * 打家劫舍
 *
 * @author jianghan
 * @date 2020-09-19 02:02
 */
public class HouseRobber_198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        } else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            dp[2] = Math.max(nums[0] + nums[2], nums[1]);
            dp(nums, dp);
            Arrays.sort(dp);
            return dp[nums.length - 1];
        }
    }

    //n>=3
    //dp[n] = MAX(dp[n-2],dp[n-3])+nums[n-1]
    private void dp(int[] nums, int[] dp) {
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
    }

    public static void main(String[] args) {
        HouseRobber_198 houseRobber_198 = new HouseRobber_198();
        houseRobber_198.rob(new int[]{1,2,3,1});
    }
}
