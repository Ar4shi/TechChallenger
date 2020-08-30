package com.leetcode.Solution01_100.solution21_30;

/**
 * 移除元素
 *
 * @author jianghan
 * @date 2019-07-01 14:06
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        return function_01(nums,val);
    }

    /**
     * 方法一：快慢双指针
     */
    private int function_01(int[] nums, int val){
        if(nums.length==0){return 0;}
        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
