package com.leetcode.Solution501_600.Solution521_530;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 *
 * @author jianghan
 * @date 2020-09-11 01:02
 */
public class ContiguousArray_525 {
    int max = 0;

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count -= 1;
            } else {
                count += 1;
            }
            if (map.get(count) == null) {
                map.put(count, i);
            } else {
                max = Math.max(i - map.get(count), max);
            }
        }
        return max;
    }


    //暴力法:超时
    public int findMaxLengthTimeOut(int[] nums) {
        if (nums.length < 2) {
            return max;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int countZeor = 0;
            int countOne = 0;
            if (nums[i] == 0) {
                countZeor += 1;
            } else {
                countOne += 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    countZeor += 1;
                } else {
                    countOne += 1;
                }
                if (countOne == countZeor) {
                    max = Math.max(max, countOne + countZeor);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContiguousArray_525 contiguousArray_525 = new ContiguousArray_525();
        contiguousArray_525.findMaxLength(new int[]{0, 1, 0, 1, 0, 1});
    }
}
