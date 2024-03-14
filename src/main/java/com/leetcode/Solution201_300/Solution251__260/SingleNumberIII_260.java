package com.leetcode.Solution201_300.Solution251__260;


import java.util.*;

/**
 * 只出现一次的数字 III
 *
 * @author jianghan
 * @date 2020-09-12 02:56
 */
public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(array -> {
            if (set.contains(array)) {
                set.remove(array);
            } else {
                set.add(array);
            }
        });
        List<Integer> list = new ArrayList<>(set);
        return new int[]{list.get(0), list.get(1)};
    }
}
