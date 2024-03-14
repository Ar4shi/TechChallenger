package com.leetcode.Solution01_100.Solution51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 最后一个单词的长度
 *
 * @author jianghan
 * @date 2020-09-20 21:43
 */
public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        List<Character> list = new ArrayList<>();
        for(int i = 0 ;i<s.length();i++){
            if(s.charAt(i)== ' '){
                if(i==s.length()-1||s.charAt(i+1)==' '){
                    continue;
                }else {
                    list.clear();
                }
            }else {
                list.add(s.charAt(i));
            }
        }
        return list.size();
    }
}
