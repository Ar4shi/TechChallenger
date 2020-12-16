package com.leetcode.Solution201_300.Solution281_290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 单词规律
 *
 * @author jianghan
 * @date 2020-12-16 21:02
 */
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(s1[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), s1[i]);
            }
        }
        Set<String> set = new HashSet<>();
        for(Character c :map.keySet()){
            set.add(map.get(c));
        }
        return map.size() == set.size();
    }
}
