package com.sword.Solution11_20;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author jianghan
 * @date 2021-03-21 01:22
 */
public class MinArray_11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[left] > numbers[mid]) {//旋转点在这个区间
                right = mid;
            } else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else {//由于可能重复所以缩短末尾
                right--;
            }
        }
        return numbers[left];
    }
}
