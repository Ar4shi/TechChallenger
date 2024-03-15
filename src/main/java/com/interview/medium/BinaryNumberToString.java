package com.interview.medium;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用[32]位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * 输入：0.625
 * 输出："0.101"
 * <p>
 * 示例2:
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * 重要：
 * 32位包括输出中的 "0." 这两位。
 * 题目保证输入用例的小数位数最多只有 6 位
 */
public class BinaryNumberToString {

    public String printBin(double num) {
        String result = "0.";
        while (num != 0) {
            num *= 2;
            if (num > 1) {
                result += "1";
                num -= 1;
            } else if (num < 1) {
                result += "0";
            } else {
                return result + "1";
            }
            if (result.length() > 32) {
                return "ERROR";
            }
        }
        return result;
    }
}
