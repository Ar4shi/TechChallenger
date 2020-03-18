package com.leetcode.Solution1001_1100.Solution1071_1080;

/**
 * 字符串的最大公因子
 *
 * @author jianghanh
 * @date 2020-03-12 00:47
 */
public class GreatestCommonDivisorOfStrings_1071 {
    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        //获取较短的那个字符串用于遍历所有子串
        String shortWord = str1.length() <= str2.length() ? str1 : str2;
        for (int i = 0; i < shortWord.length(); i++) {
            String substring = shortWord.substring(0, i+1);
            if (substring.length() > res.length() && "".equals(str1.replaceAll(substring, "")) && "".equals(str2.replaceAll(substring, ""))) {
                res = substring;
            }

        }
        return res;
    }
}
