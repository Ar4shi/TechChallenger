package com.leetcode.Solution31_40;

/**
 * 搜索插入位置
 *
 * @author jianghanh
 * @date 2020-02-04 17:51
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;

        int result = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]>=target){
                result = i;
                break;
            }else {
                if(i == nums.length-1){
                    result = nums.length;
                }
            }
        }
        return  result;
    }
}
