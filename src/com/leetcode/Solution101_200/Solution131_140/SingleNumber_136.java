package com.leetcode.Solution101_200.Solution131_140;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 *
 * @author jianghan
 * @date 2020-09-22 22:28
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }
}
