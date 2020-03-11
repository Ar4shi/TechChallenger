package com.leetcode.Solution01_100.solution11_20;

/**
 *  最长公共前缀
 *
 * @author jianghanh
 * @date 2019-06-26 10:34
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String result = getProfix(strs[0],strs[1]);
        if(strs.length==2) return result;
        for(int i = 2;i<strs.length;i++){
            result = getProfix(result,strs[i]);
        }
        return result;
    }

    /**
     * 两个字符串获取最长前缀
     */
    private String getProfix(String str1,String Str2){
        if(str1.length()==0||Str2.length()==0) return "";
        StringBuffer result = new StringBuffer();
        int length = str1.length()<=Str2.length()?str1.length():Str2.length();
        for(int i = 0;i<length;i++){
            if(str1.charAt(i)==Str2.charAt(i)){
                result.append(str1.charAt(i));
            }else{
                return result.toString();
            }
        }
        return result.toString();
    }
}
