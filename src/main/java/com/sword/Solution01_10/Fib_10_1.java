package com.sword.Solution01_10;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * @author jianghan
 * @date 2021-03-21 00:25
 */
public class Fib_10_1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] content = new int[n + 1];
        content[0] = 0;
        content[1] = 1;
        for (int i = 2; i <= n; i++) {
            content[i] = (content[i - 1] + content[i - 2]) % 1000000007;
        }
        return content[n];
    }

    public static void main(String[] args) {
        Fib_10_1 fib_10_1 = new Fib_10_1();
        fib_10_1.fib(48);
    }
}
