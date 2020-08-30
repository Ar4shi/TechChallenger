package com.leetcode.Solution401_500.Solution401_410;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 *
 * @author jianghan
 * @date 2020-03-19 00:48
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        int res = 0;
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                res += map.get(c);
            } else {
                oddCount++;
                res +=map.get(c)-1;
            }
        }
        if(oddCount == 0){
            return res;
        }else return res+1;
    }
}
