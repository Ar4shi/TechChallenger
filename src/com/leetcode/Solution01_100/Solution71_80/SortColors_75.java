package com.leetcode.Solution01_100.Solution71_80;

import java.util.*;

/**
 * 颜色分类
 *
 * @author jianghan
 * @date 2020-09-16 01:04
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                map.put(0, map.get(0) + 1);
            } else if (nums[i] == 1) {
                map.put(1, map.get(1) + 1);
            } else {
                map.put(2, map.get(2) + 1);
            }
        }
        for (int i = 0; i < map.get(0); i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < map.get(1); i++) {
            nums[i + map.get(0)] = 1;
        }
        for (int i = 0; i < map.get(2); i++) {
            nums[i + map.get(0) + map.get(1)] = 2;
        }
    }
}
