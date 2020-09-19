package com.leetcode.Solution301_400.Solution301_310;

/**
 * 区域和检索 - 数组不可变
 *
 * @author jianghan
 * @date 2020-09-19 02:28
 */
public class RangeSumQueryImmutable_303 {
    int[] dp;
    int[] nums;

    public RangeSumQueryImmutable_303(int[] nums) {
        dp = new int[nums.length];
        this.nums = nums;
        if (nums.length > 1) {
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] + dp[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if(i==0){
            return dp[j];
        }else {
            return dp[j] - dp[i - 1];
        }
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable_303 rangeSumQueryImmutable_303 = new RangeSumQueryImmutable_303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(rangeSumQueryImmutable_303.sumRange(0,5));
    }
}
