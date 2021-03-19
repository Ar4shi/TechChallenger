package com.sword.Solution01_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * @author jianghan
 * @date 2021-03-20 00:50
 */
public class FindRepeatNumber_03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindRepeatNumber_03 findRepeatNumber_03 = new FindRepeatNumber_03();
        findRepeatNumber_03.findRepeatNumber(new int[]{3, 1, 2, 3});
    }
}
