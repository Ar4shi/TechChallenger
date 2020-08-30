package com.leetcode.Solution01_100.solution11_20;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author jianghan
 * @date 2019-06-26 15:56
 */
public class SumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        int closestDistance = Integer.MAX_VALUE;//初始化最近距离
        int closestValue = Integer.MAX_VALUE;//初始化最近数值
        Arrays.sort(nums);//排个序先
        for(int i = 0;i<nums.length-2;i++){//初始化第一个数位置
            int left = i+1;//初始化第二个数位置
            int right = nums.length-1;//初始化第三个数位置
            while (left<right){
                int temp = nums[i]+nums[left]+nums[right];
                if(temp>=target){
                    int distance = temp - target;
                    if(distance<closestDistance){
                        closestDistance = distance;
                        closestValue = temp;
                    }
                    right--;
                }else{
                    int distance = target - temp;
                    if(distance<closestDistance){
                        closestDistance = distance;
                        closestValue = temp;
                    }
                    left++;
                }
            }
        }
        return closestValue;
    }
}
