package com.leetcode.Solution301_400.Solution311_320;

import java.util.Stack;

/**
 * 去除重复字母
 *
 * @author jianghan
 * @date 2020-12-20 01:50
 */
public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        //初始化一个长度为26的数组容器存放s中字符出现的次数
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        //单调栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    //如果单调栈中已经存在这个字符说明之前已经排好了,直接舍弃这个字符
                    if (stack.contains(s.charAt(i))) {
                        array[s.charAt(i) - 'a']--;
                        break;
                    }
                    Character topChar = stack.peek();
                    if (array[topChar - 'a'] > 1 && topChar > s.charAt(i)) {
                        stack.pop();
                        array[topChar - 'a']--;
                    } else {
                        stack.add(s.charAt(i));
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    stack.add(s.charAt(i));
                }
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop().toString() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters_316 removeDuplicateLetters_316 = new RemoveDuplicateLetters_316();
        removeDuplicateLetters_316.removeDuplicateLetters("abacb");
    }
}
