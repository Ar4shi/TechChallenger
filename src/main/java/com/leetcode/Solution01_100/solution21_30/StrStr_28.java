package com.leetcode.Solution01_100.solution21_30;

/**
 * 实现strStr()
 *
 * @author jianghan
 * @date 2019-07-01 14:20
 */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        return function_01(haystack,needle);
    }

    /**
     * 方法一 : 暴力法
     */
    private int function_01(String haystack, String needle){
        if(haystack.length()<needle.length()){return -1;}
        if(haystack.length()==needle.length()){
            if(haystack.equals(needle)){
                return 0;
            }else {
                return -1;
            }
        }
        if(needle.length()==0){return 0;}
        for(int i = 0;i<=haystack.length()-needle.length();i++){
            int count = 0;
            while (count<needle.length()){
                if(haystack.charAt(i+count)!=needle.charAt(count)){
                    break;
                }else{
                    if(count == needle.length()-1){
                        return i;
                    }
                }
                count++;
            }
        }
        return -1;
    }
}
