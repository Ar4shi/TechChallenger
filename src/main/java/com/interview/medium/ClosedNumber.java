package com.interview.medium;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class ClosedNumber {

    public static int[] findClosedNumbers(int num) {
        int[] res = {-1, -1};
        long max = (long) num << 1;
        int min = num >> 1;
        if (num == 0 || num == 2147483647) {
            return res;
        }
        int oneCount = countOneNum(num);
        for (int i = num + 1; i <= max; i++) {
            if (oneCount == countOneNum(i)) {
                res[0] = i;
                break;
            }
        }
        for (int i = num - 1; i >= min; i--) {
            if (oneCount == countOneNum(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }


    public static int countOneNum(long num) {
        String str = Long.toBinaryString(num);
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
}
