package com.sword.Solution31_40;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 纯调试调出来的
 *
 * @author jianghan
 * @date 2021-03-31 23:56
 */
public class ValidateStackSequences_31 {
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

    public static void main(String[] args) {
        ValidateStackSequences_31 validateStackSequences_31 = new ValidateStackSequences_31();
        validateStackSequences_31.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
