package com.leetcode.Solution31_40;

/**
 * 下一个排列
 *
 * @author jianghanh
 * @date 2020-01-23 16:12
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if(nums.length>1) {
            for(int i = 0 ;i<nums.length-2;i++){

            }
        }
    }

    /**
     * 交换数组的两个数字的位置
     */
    private void swapNum(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
