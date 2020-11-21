package com.leetcode.Solution01_100.Solution41_50;

import java.util.*;

/**
 * 字符串相乘
 *
 * @author jianghan
 * @date 2020-11-20 15:07
 */
public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        String result = "0";
        List<String> list = new LinkedList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int zeroCount = num2.length() - 1 - i;
            String str = mutipOne(num1, num2.charAt(i));
            sb.append(str);
            for (int j = zeroCount; j > 0; j--) {
                sb.append("0");
            }
            list.add(sb.toString());
        }
        for (String str : list) {
            result = addTwoString(result, str);
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<result.length();i++){
            set.add(result.charAt(i));
        }
        if(set.size() == 1){
            for(Character c : set){
                if(c.equals('0')){
                    result = "0";
                }
            }
        }
        return result;
    }

    private String addTwoString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        Stack<String> stack = new Stack<>();
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i + num1.length() - num2.length()) - '0';
            int b = num2.charAt(i) - '0';
            int result = a + b + carry;
            carry = result / 10;
            stack.push(String.valueOf(result % 10));
        }
        for (int i = num1.length() - num2.length() - 1; i >= 0; i--) {
            int result = num1.charAt(i) - '0' + carry;
            carry = result / 10;
            stack.push(String.valueOf(result % 10));
        }
        if (carry != 0) {
            stack.push(String.valueOf(carry));
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private String mutipOne(String num, char c) {
        StringBuilder sb = new StringBuilder();
        int one = c - '0';
        int carry = 0;
        Stack<String> stack = new Stack<>();
        for (int i = num.length() - 1; i >= 0; i--) {
            int a = num.charAt(i) - '0';
            int result = a * one + carry;
            carry = result / 10;
            stack.push(String.valueOf(result % 10));
        }
        if (carry != 0) {
            stack.push(String.valueOf(carry));
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings_43 multiplyStrings_43 = new MultiplyStrings_43();
        System.out.println(multiplyStrings_43.multiply("9999999999999999999999999999999999999999999999999", "0"));
    }
}
