package com.leetcode.solution11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author jianghanh
 * @date 2019-06-26 19:45
 */
public class Sum4_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);//还是排个序先
        for (int i = 0; i < nums.length - 3; i++) {//初始化第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }//去重
            for (int j = i + 1; j < nums.length - 2; j++) {//初始化第二个数
                if (j >i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }//去重
                int left = j + 1;//初始化第三个数
                int right = nums.length - 1;//初始化第四个数
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        resultList.add(list);
                        while (left < right&&nums[left] == nums[left + 1]) {//去重
                            left++;
                        }
                        while (left < right&&nums[right] == nums[right - 1]) {//去重
                            right--;
                        }
                        left++;
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return resultList;
    }
}
