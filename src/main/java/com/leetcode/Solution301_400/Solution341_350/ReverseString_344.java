package com.leetcode.Solution301_400.Solution341_350;

/**
 * 反转字符串
 *
 * @author jianghan
 * @date 2020-10-08 20:11
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        for (int i = 0; i < s.length / 2; i++) {
            int j = s.length - i - 1;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
