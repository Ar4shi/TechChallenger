package com.leetcode.Solution101_200.Solution161_170;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author jianghanh
 * @date 2020-03-13 00:42
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Integer count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for(Integer key:map.keySet()){
            if(map.get(key)>(nums.length*0.5)){
                res = key;
            }
        }
        return res;
    }
}
