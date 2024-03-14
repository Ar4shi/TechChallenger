package com.leetcode.Solution01_100.Solution31_40;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author jianghan
 * @date 2020-11-20 01:04
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int l = mid - 1;
                int r = mid + 1;
                boolean flag1 = true;
                boolean flag2 = true;
                while (flag1 || flag2) {
                    if (l >= 0 && nums[l] == target) {
                        l -= 1;
                    } else {
                        flag1 = false;
                    }
                    if (r < nums.length && nums[r] == target) {
                        r += 1;
                    } else {
                        flag2 = false;
                    }
                }
                return new int[]{l + 1, r - 1};
            }
            //左半区
            if (nums[0] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray_34 findFirstAndLastPositionOfElementInSortedArray_34 = new FindFirstAndLastPositionOfElementInSortedArray_34();
        findFirstAndLastPositionOfElementInSortedArray_34.searchRange(new int[]{2, 2}, 2);
    }
}
