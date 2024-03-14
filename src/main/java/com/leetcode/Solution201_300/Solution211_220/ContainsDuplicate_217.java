package com.leetcode.Solution201_300.Solution211_220;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author jianghan
 * @date 2020-12-13 23:49
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }
}
