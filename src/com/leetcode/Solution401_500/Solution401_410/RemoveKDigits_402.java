package com.leetcode.Solution401_500.Solution401_410;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉K位数字
 *
 * @author jianghan
 * @date 2020-11-15 11:45
 */
public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits_402 removeKDigits_402 = new RemoveKDigits_402();
        removeKDigits_402.removeKdigits("1173", 2);
    }
}
