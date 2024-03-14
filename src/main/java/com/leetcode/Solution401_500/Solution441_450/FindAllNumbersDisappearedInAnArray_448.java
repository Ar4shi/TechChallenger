package com.leetcode.Solution401_500.Solution441_450;

import java.util.*;

/**
 * 找到所有数组中消失的数字
 *
 * @author jianghan
 * @date 2021-02-13 23:15
 */
public class FindAllNumbersDisappearedInAnArray_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 没认真审题随便写的 超时了
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            boolean notExist = true;
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]) {
                    notExist = false;
                    break;
                }
            }
            if (notExist) {
                list.add(i);
            }
        }
        return list;
    }
}
