package com.leetcode.Solution01_100.solution01_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author jianghan
 * @date 2019-06-16 20:33
 */
public class LongestSubstring_03 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character,Integer> strMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if(strMap.containsKey(s.charAt(i))){
                result = strMap.size()>result?strMap.size():result;
                i = strMap.get(s.charAt(i))+1;//修改i指向
                strMap.clear();
                strMap.put(s.charAt(i),i);//重新放入第一个元素
            }else{
                strMap.put(s.charAt(i),i);
            }
        }
        result = strMap.size()>result?strMap.size():result;
        return result;
    }
}
