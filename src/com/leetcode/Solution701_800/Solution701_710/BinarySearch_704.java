package com.leetcode.Solution701_800.Solution701_710;

/**
 * 二分查找
 * 二分法入门题
 *
 * @author jianghan
 * @date 2021-02-01 01:25
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        //二分法基础模板
        while (left <= right) {
            mid = (left + right) >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch_704 binarySearch_704 = new BinarySearch_704();
        binarySearch_704.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
    }
}
