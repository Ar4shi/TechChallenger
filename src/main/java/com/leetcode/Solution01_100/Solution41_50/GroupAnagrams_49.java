package com.leetcode.Solution01_100.Solution41_50;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author jianghan
 * @date 2020-09-27 23:10
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                result.get(map.get(key)).add(str);
            } else {
                map.put(key, result.size());
                result.add(new ArrayList<String>() {{
                    this.add(str);
                }});
            }
        }
        return result;
    }
}
