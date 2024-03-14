package com.leetcode.Solution901_1000.Solution941_950;

import java.util.Stack;

/**
 * 验证栈序列
 *
 * @author jianghan
 * @date 2021-04-01 00:25
 */
public class ValidateStackSequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0) {
            return true;
        }
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                continue;
            }
            while (j < pushed.length && pushed[j] != popped[i]) {
                stack.push(pushed[j++]);
            }
            if (j < pushed.length) {
                stack.push(pushed[j++]);
            }
            if (stack.peek() != popped[i]) {
                result = false;
                break;
            } else {
                stack.pop();
            }
        }
        return result;
    }
}
