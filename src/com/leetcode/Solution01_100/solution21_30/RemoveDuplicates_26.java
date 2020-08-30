package com.leetcode.Solution01_100.solution21_30;

/**
 * 删除排序数组中的重复项
 *
 * @author jianghan
 * @date 2019-07-01 13:31
 */
public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
       return function_01(nums);
    }

    /**
     * 方法一： 快慢双指针法
     */
    private int function_01(int[] nums){
        if(nums.length<=1){return nums.length;}
        int slow = 0;
        int fast = 1;
        while (fast<nums.length){
            if(nums[slow]!=nums[fast]){
                nums[slow+1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }
}
