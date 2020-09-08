package com.leetcode.Solution01_100.Solution51_60;

/**
 * 最大子序和
 *
 * @author jianghan
 * @date 2020-09-08 22:32
 */
public class MaximumSubarray_53 {
    int res = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSubarray_53 maximumSubarray_53 = new MaximumSubarray_53();
        maximumSubarray_53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
