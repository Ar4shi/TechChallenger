package com.sword.Solution41_50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * @author jianghan
 * @date 2021-05-18 23:40
 */
public class LengthOfLongestSubstring_48 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (strMap.containsKey(s.charAt(i))) {
                result = strMap.size() > result ? strMap.size() : result;
                i = strMap.get(s.charAt(i)) + 1;//修改i指向
                strMap.clear();
                strMap.put(s.charAt(i), i);//重新放入第一个元素
            } else {
                strMap.put(s.charAt(i), i);
            }
        }
        result = strMap.size() > result ? strMap.size() : result;
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_48 lengthOfLongestSubstring_48 = new LengthOfLongestSubstring_48();
        lengthOfLongestSubstring_48.lengthOfLongestSubstring("aab");
    }
}
