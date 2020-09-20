package com.leetcode.Solution01_100.Solution61_70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 加一
 *
 * @author jianghan
 * @date 2020-09-20 21:52
 */
public class PlusOne_66 {
    boolean needPlus = true;

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int currentNum = digits[i];
            if (needPlus) {
                currentNum += 1;
                if (currentNum == 10) {
                    digits[i] = 0;
                } else {
                    digits[i] = currentNum;
                    needPlus = false;
                }
            } else {
                digits[i] = currentNum;
            }
        }
        if (needPlus) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}
