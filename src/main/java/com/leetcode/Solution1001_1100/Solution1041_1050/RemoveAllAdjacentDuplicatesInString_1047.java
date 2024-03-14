package com.leetcode.Solution1001_1100.Solution1041_1050;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻重复项
 *
 * @author jianghan
 * @date 2021-03-09 23:56
 */
public class RemoveAllAdjacentDuplicatesInString_1047 {

    public String removeDuplicates(String S) {
        if (S.length() < 2) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(S.length() - 1));
        for (int i = S.length() - 2; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
                continue;
            }
            if (S.charAt(i) == stack.peek()) {
                stack.pop();
            }else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString_1047 removeAllAdjacentDuplicatesInString_1047 = new RemoveAllAdjacentDuplicatesInString_1047();
        removeAllAdjacentDuplicatesInString_1047.removeDuplicates("abbaca");
    }
}
