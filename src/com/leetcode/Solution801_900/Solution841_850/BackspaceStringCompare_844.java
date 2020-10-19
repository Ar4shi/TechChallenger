package com.leetcode.Solution801_900.Solution841_850;

import java.util.Stack;

/**
 * 比较含退格的字符串
 *
 * @author jianghan
 * @date 2020-10-19 21:09
 */
public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }
        String res1 = "";
        String res2 = "";
        while (!stackS.isEmpty()) {
            res1 += String.valueOf(stackS.pop());
        }
        while (!stackT.isEmpty()) {
            res2 += String.valueOf(stackT.pop());
        }
        return res1.equals(res2);
    }

    public static void main(String[] args) {
        BackspaceStringCompare_844 backspaceStringCompare_844 = new BackspaceStringCompare_844();
        backspaceStringCompare_844.backspaceCompare("y#fo##f", "y#f#o##f");
    }
}
