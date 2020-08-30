package com.leetcode.Solution01_100.solution11_20;

/**
 * 整数转罗马数字
 *
 * @author jianghan
 * @date 2019-06-25 10:57
 */
public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; //枚举出所有可能的不符合一般性规则(小的数字在大的数字的右边)的数值
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//上述数值对应的字符
        for (int i = 0; i < values.length; i++) {
            int count = num / values[i];
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    stringBuffer.append(strings[i]);
                    num -= values[i];
                }
            }
        }
        return stringBuffer.toString();
    }
}
