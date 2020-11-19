package com.leetcode.Solution01_100.Solution31_40;

/**
 * 搜索旋转排序数组
 *
 * @author jianghan
 * @date 2020-02-27 11:15
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) >> 1;
            //翻转点在左区间
            if (nums[left] > nums[mid]) {
                //target 在 左区间
                if (nums[left] >= target && nums[mid] <= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {//翻转点在右区间
                //target 在右区间
                if (nums[right] >= target && nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 searchInRotatedSortedArray_33 = new SearchInRotatedSortedArray_33();
        searchInRotatedSortedArray_33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }
}
