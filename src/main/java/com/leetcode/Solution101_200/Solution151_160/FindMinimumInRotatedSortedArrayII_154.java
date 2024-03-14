package com.leetcode.Solution101_200.Solution151_160;

/**
 * 寻找旋转排序数组中的最小值 II
 * 同剑指offer MinArray_11
 *
 * @author jianghan
 * @date 2021-03-21 23:14
 */
public class FindMinimumInRotatedSortedArrayII_154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[left] > nums[mid]) {//旋转点在这个区间
                right = mid;
            } else if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
