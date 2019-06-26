package com.leetcode;

import com.leetcode.solution01_10.ZConvert_06;
import com.leetcode.solution11_20.MostWater_11;

/**
 * 测试类
 *
 * @author jianghanh
 * @date 2019-06-14 21:15
 */
public class Test {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        MostWater_11 mostWater_11 = new MostWater_11();
        mostWater_11.maxArea(height);
    }
}
