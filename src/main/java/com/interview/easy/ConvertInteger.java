package com.interview.easy;


/**
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * <p>
 * 示例2:
 * 输入：A = 1，B = 2
 * 输出：2
 * <p>
 * 提示:
 * A，B范围在[-2147483648, 2147483647]之间
 */
public class ConvertInteger {

    public int convertInteger(int A, int B) {
        int result = A ^ B;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((result & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
