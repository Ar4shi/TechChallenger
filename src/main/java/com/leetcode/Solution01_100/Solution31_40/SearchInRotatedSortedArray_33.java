package com.leetcode.Solution01_100.Solution31_40;

/**
 * 搜索旋转排序数组
 *
 * @author jianghan
 * @date 2020-02-27 11:15
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //左半区未反转
            if (nums[0] <= nums[mid]) {
                //在左半区
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    //在右半区
                    left = mid + 1;
                }
            } else {//左半区有反转
                //在右半区
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    //在左半区
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 searchInRotatedSortedArray_33 = new SearchInRotatedSortedArray_33();
        searchInRotatedSortedArray_33.search(new int[]{1, 3, 5}, 1);
    }
}
