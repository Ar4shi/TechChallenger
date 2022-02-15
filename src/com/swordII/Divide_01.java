package com.swordII;

/**
 * 整数除法
 *
 * @author jianghan
 * @date 2022-02-16 01:56
 */
public class Divide_01 {

    public int divide(int a, int b) {
        long result = 0;
        if (a == 0) return 0;
        if (a > 0 && b > 0) {
            while (a > 0) {
                a = a - b;
                result++;
            }
            if (a == 0) {
                result++;
            }
            result--;
        } else if (a < 0 && b > 0) {
            while (a < 0) {
                a = a + b;
                result--;
            }
            if (a == 0) {
                result--;
            }
            result++;
        } else if (a > 0 && b < 0) {
            while (a > 0) {
                a = a + b;
                result--;
            }
            if (a == 0) {
                result--;
            }
            result++;
        } else if (a < 0 && b < 0) {
            while (a < 0) {
                a = a - b;
                result++;
            }
            if (a == 0) {
                result++;
            }
            result--;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int) result;
    }
}
