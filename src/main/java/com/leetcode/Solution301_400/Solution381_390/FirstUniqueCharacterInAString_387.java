package com.leetcode.Solution301_400.Solution381_390;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * @author jianghan
 * @date 2020-12-23 01:31
 */
public class FirstUniqueCharacterInAString_387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
