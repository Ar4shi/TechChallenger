package com.leetcode.Solution01_100.solution01_10;

import java.util.HashMap;

/**
 * 两数之和
 * 利用hashmap.containkey时间复杂度位O（1）的特性,避免进行两次循环降低复杂度
 * hashmap根据Key生成hashcode，重复的hashcode会以链表的形式挂载在同一个arraylist下.
 * containkey方法根据key生成hashcode转化为arraylist的数组下标，若冲突再根据挂载在arraylist下linkedlist找到对应的值，所以在不冲突的情况下复杂度位O(1)最小期望为O（n）
 *
 * @author jianghanh
 * @date 2019-06-12 19:05
 */
public class TwoSum_01 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                return result;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }

}

