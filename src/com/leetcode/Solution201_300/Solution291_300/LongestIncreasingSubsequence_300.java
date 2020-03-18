package com.leetcode.Solution201_300.Solution291_300;

/**
 * 最长上升子序列
 *
 * @author jianghanh
 * @date 2020-03-14 14:49
 */
public class LongestIncreasingSubsequence_300 {
    int res = 0;
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        for(int i = 0;i<nums.length;i++){
            int length = 1;
            int temp = nums[i];
            for(int j = i;j<nums.length;j++){
                if(nums[j]>temp){
                    length+=1;
                    temp = nums[j];
                }
            }
            res = Math.max(res,length);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] sss = new int[]{10,9,2,5,3,4};
        new LongestIncreasingSubsequence_300().lengthOfLIS(sss);
    }
}
