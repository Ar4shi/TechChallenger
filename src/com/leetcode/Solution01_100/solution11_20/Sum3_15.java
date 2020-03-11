package com.leetcode.Solution01_100.solution11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author jianghanh
 * @date 2019-06-26 11:01
 */
public class Sum3_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) return resultList;
        Arrays.sort(nums);//先排序
        for (int i = 0; i < nums.length - 2; i++) {//固定第一位
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }//去重保证第一位不相同
            int left = i + 1;//第二位初始位置
            int right = nums.length - 1;//第三位初始位置
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }//去重 保证第二位不相同
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }//去重 保证第三位不相同
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return resultList;
    }
}
