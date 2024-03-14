package com.leetcode.Solution201_300.Solution281_290;

/**
 * 移动零
 *
 * @author jianghan
 * @date 2020-11-19 00:22
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int index = -1;
                    for (int j = i - 1; j >= 0; j--) {
                        if (nums[j] == 0) {
                            index = j;
                        }
                    }
                    if (index >= 0) {
                        swap(nums, i, index);
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
