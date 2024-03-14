package com.leetcode.Solution201_300.Solution241_250;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * @author jianghan
 * @date 2020-11-22 15:36
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = getMap(s);
        Map<Character, Integer> map2 = getMap(t);
        for (Character c : map1.keySet()) {
            if(!map1.get(c).equals(map2.get(c))){
                return false;
            }
        }
        for (Character c : map2.keySet()) {
            if(!map2.get(c).equals(map1.get(c))){
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                Integer num = map.get(c);
                map.put(c, num + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
