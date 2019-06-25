package com.leetcode.solution01_10;

/**
 * 最长回文子串
 *
 * @author jianghanh
 * @date 2019-06-17 19:00
 */
public class Palindrome_05 {
    public String longestPalindrome(String s) {
        if (s.length()==0) return "";
        String result = s.substring(0,1);//回文字符串
        if(s.length()==1) return result;
        for(int i = 2;i<=s.length();i++){//以截取字符串的长度为基准开始遍历
            for(int j = 0;j<=s.length()-i;j++){
                if(isPalindrome(s.substring(j,j+i))){
                    result = s.substring(j,j+i);
                    break;//如果存在回文则直接跳过本长度节约时间
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串是否是回文
     * 无论s的长度是奇数还是偶数都除以二并舍弃小数点后面,对回文结果判断无影响
     * @return
     */
    public boolean isPalindrome(String s) {
        int half = s.length()/2;
        for (int i = 0; i < half; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
