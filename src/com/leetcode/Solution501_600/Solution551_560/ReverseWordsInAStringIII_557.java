package com.leetcode.Solution501_600.Solution551_560;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 反转字符串中的单词 III
 *
 * @author jianghan
 * @date 2020-08-30 23:49
 */
public class ReverseWordsInAStringIII_557 {
    public String reverseWords(String s) {
        String result = "";
        Stack<String> words = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (!words.isEmpty()) {
                    result += words.pop();
                }
                result += " ";
            } else {
                words.push(String.valueOf(s.charAt(i)));
            }
        }
        while (!words.isEmpty()) {
            result += words.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII_557 reverseWordsInAStringIII_557 = new ReverseWordsInAStringIII_557();
        System.out.println(reverseWordsInAStringIII_557.reverseWords("abc efg hij"));
    }
}
