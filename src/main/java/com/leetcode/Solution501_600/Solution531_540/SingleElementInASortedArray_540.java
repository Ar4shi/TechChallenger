package com.leetcode.Solution501_600.Solution531_540;

/**
 * 有序数组中的单一元素
 *
 * @author jianghan
 * @date 2022-02-14 02:39
 */
public class SingleElementInASortedArray_540 {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            boolean result = checkNum(nums, mid);
            if (result) {
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid - 1]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    private boolean checkNum(int[] nums, int index) {
        if (index - 1 < 0 || index + 1 > nums.length - 1) {
            return false;
        }
        return nums[index] == nums[index - 1] || nums[index] == nums[index + 1];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray_540 singleElementInASortedArray_540 = new SingleElementInASortedArray_540();
        singleElementInASortedArray_540.singleNonDuplicate(new int[]{1, 2, 2, 3, 3});
    }
}
