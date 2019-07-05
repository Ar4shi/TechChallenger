package com.leetcode.solution21_30;

/**
 * 两数相除
 *
 * @author jianghanh
 * @date 2019-07-01 15:55
 */
public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int symbol = (dividend ^ divisor) >> 31;//取异或后再带符号右移(>>)31位获得符号位得异或值 0位同 1为异号
        long a = (long) dividend;//转为long 防止溢出
        long b = (long) divisor;
        if (symbol == 0) {
            long result = caculate(a > 0 ? a : (0 - a), b > 0 ? b : (0 - b));
            return (int) (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result);
        } else {
            long result = caculate(a > 0 ? a : (0 - a), b > 0 ? b : (0 - b));
            return (int) ((0 - result) < Integer.MIN_VALUE ? Integer.MAX_VALUE : (0 - result));
        }
    }

    /**
     * 商值计算
     */
    private long caculate(long dividend, long divisor) {
        long result = 0;
        while (dividend >= divisor) {
            long currentDivisor = divisor;//当前被除数
            long rate = 1;//倍率初始化 1 倍
            while (dividend >= currentDivisor) {
                dividend-=currentDivisor;
                result += rate;
                rate<<=1;//倍率翻倍
                currentDivisor<<=1;//被除数翻倍
            }
        }
        return result;
    }
}
