package com.interview.medium;

import java.util.Arrays;

/**
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 示例:
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * <p>
 * 输出: [5, 1, 3, 2, 3]
 * <p>
 * 提示：
 * nums.length <= 10000
 */
public class PeaksAndValleys {

    public void wiggleSort(int[] nums) {
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArray);
        int left = 0;
        int right = copyArray.length - 1;
        int count = 0;
        while (left <= right) {
            if (left == right) {
                nums[count] = copyArray[left];
                break;
            }
            nums[count++] = copyArray[right--];
            nums[count++] = copyArray[left++];
        }
    }
}
