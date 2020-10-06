package com.leetcode.Solution401_500.Solution491_500;

import java.util.*;

/**
 * 键盘行
 *
 * @author jianghan
 * @date 2020-10-06 22:56
 */
public class KeyboardRow_500 {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        List<Character> characters1 = Arrays.asList('q', 'Q', 'w', 'W', 'e', 'E', 'r', 'R', 't', 'T', 'y', 'Y', 'u', 'U', 'i', 'I', 'o', 'O', 'p', 'P');
        List<Character> characters2 = Arrays.asList('a', 'A', 's', 'S', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L');
        List<Character> characters3 = Arrays.asList('z', 'Z', 'x', 'X', 'c', 'C', 'v', 'V', 'b', 'B', 'n', 'N', 'm', 'M');
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!characters1.contains(words[i].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(words[i]);
            }
        }
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!characters2.contains(words[i].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(words[i]);
            }
        }
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!characters3.contains(words[i].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(words[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}
