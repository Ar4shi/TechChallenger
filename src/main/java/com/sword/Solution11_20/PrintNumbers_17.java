package com.sword.Solution11_20;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * @author jianghan
 * @date 2021-03-24 00:46
 */
public class PrintNumbers_17 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
