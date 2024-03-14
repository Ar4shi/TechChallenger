package com.leetcode.Solution301_400.Solution321_330;

/**
 * 区间和的个数
 *
 * @author jianghan
 * @date 2020-11-07 22:45
 */
public class CountOfRangeSum_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long sum = getSum(nums, i, j);
                if (sum >= lower && sum <= upper) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private long getSum(int[] nums, int i, int j) {
        long res = 0;
        if (i == j) {
            return nums[i];
        }
        for (int k = i; k <= j; k++) {
            res += nums[k];
        }
        return res;
    }

    public static void main(String[] args) {
        CountOfRangeSum_327 countOfRangeSum_327 = new CountOfRangeSum_327();
        countOfRangeSum_327.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647},-564,3864);
    }
}
