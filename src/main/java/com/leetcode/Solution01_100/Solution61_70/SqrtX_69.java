package com.leetcode.Solution01_100.Solution61_70;

/**
 * x 的平方根
 *
 * @author jianghan
 * @date 2020-09-20 22:16
 */
public class SqrtX_69 {
    public int mySqrt(int x) {
        long result = 0;
        for (long i = 1; i <= x; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                result = i;
                break;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        SqrtX_69 sqrtX_69 = new SqrtX_69();
        sqrtX_69.mySqrt(2147395600);
    }
}
