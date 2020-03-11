package com.leetcode.Solution01_100.solution11_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author jianghanh
 * @date 2019-06-27 13:40
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', '?');
        map.put(')', '(');
        map.put('{', '?');
        map.put('}', '{');
        map.put('[', '?');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == map.get(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
