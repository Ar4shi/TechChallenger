package com.leetcode.Solution701_800.Solution741_750;

/**
 * 至少是其他数字两倍的最大数
 *
 * @author jianghan
 * @date 2022-01-13 02:16
 */
public class LargestNumberAtLeastTwiceOfOthers_747 {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        // 最大的数
        int maxIndex = 0;
        // 第二大的数
        int secondMaxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        if(maxIndex == secondMaxIndex){
            secondMaxIndex++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[secondMaxIndex] && nums[i] < nums[maxIndex]) {
                secondMaxIndex = i;
            }
        }
        return nums[maxIndex] >= (nums[secondMaxIndex] * 2) ? maxIndex : -1;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers_747 largestNumberAtLeastTwiceOfOthers_747 = new LargestNumberAtLeastTwiceOfOthers_747();
        largestNumberAtLeastTwiceOfOthers_747.dominantIndex(new int[]{1,0});
    }
}
