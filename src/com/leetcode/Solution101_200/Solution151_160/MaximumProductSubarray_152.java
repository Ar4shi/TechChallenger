package com.leetcode.Solution101_200.Solution151_160;

import java.util.ArrayList;
import java.util.List;

/**
 * 乘积最大子数组
 *
 * @author jianghan
 * @date 2020-09-26 23:13
 */
public class MaximumProductSubarray_152 {
    int max;

    //暴力DP 超时
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        this.max = nums[0];
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<Integer>() {{
            this.add(nums[0]);
        }});
        dp.add(new ArrayList<Integer>() {{
            this.add(nums[1]);
            this.add(nums[0] * nums[1]);
        }});
        this.max = Math.max(max, nums[1]);
        this.max = Math.max(max, nums[0] * nums[1]);
        for (int i = 2; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            max = Math.max(max, nums[i]);
            for (int j = i - 1; j >= 0; j--) {
                int mult = nums[i] * dp.get(i - 1).get(j);
                max = Math.max(mult, max);
                list.add(mult);
            }
            dp.add(list);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray_152 maximumProductSubarray_152 = new MaximumProductSubarray_152();
        maximumProductSubarray_152.maxProduct(new int[]{2, 3, -2, 4});
    }
}
