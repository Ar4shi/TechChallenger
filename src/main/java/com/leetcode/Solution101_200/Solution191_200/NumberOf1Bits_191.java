package com.leetcode.Solution101_200.Solution191_200;

/**
 * 位1的个数
 * 同剑指offer HammingWeight_15
 *
 * @author jianghan
 * @date 2021-03-21 23:17
 */
public class NumberOf1Bits_191 {
    // you need to treat n as an unsigned value

    //任何一个整数n 若 与1做【与运算】
    //即 n & 1 --->  10010101 & 00000001
    //可以发现若结果为1则最后一位为1 若为0则最后一位为0
    //利用位移>>1 做循环判断 就能直到一共有多少个1了
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }
}
