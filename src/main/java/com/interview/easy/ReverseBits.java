package com.interview.easy;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * 输入: num = 1775(11011101111)
 * 输出: 8
 * <p>
 * 示例 2：
 * 输入: num = 7(0111)
 * 输出: 4
 */
public class ReverseBits {

    public int reverseBits(int num) {
        int[] bitArray = getBitArray(num);
        int max = getLongest(bitArray);
        for (int i = 0; i < 32; i++) {
            if (bitArray[i] == 0) {
                bitArray[i] = 1;
                max = Math.max(max, getLongest(bitArray));
                // 还原
                bitArray[i] = 0;
            }
        }
        return max;
    }

    private int[] getBitArray(int num) {
        int[] bitArray = new int[32];
        for (int i = 0; i < 32; i++) {
            bitArray[i] = num & 1;
            num = num >> 1;
        }
        return bitArray;
    }

    /**
     * 获取最长的1的长度
     */
    private int getLongest(int[] bitArray) {
        int[] dp = new int[32];
        dp[0] = bitArray[0];
        dp[1] = bitArray[0] + bitArray[1];
        for (int i = 2; i < 32; i++) {
            int currentBit = bitArray[i];
            if (currentBit == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], getNearOneCount(bitArray, i));
            }
        }
        return dp[31];
    }

    /**
     * 获取最近的1的个数
     */
    private int getNearOneCount(int[] bitArray, int index) {
        int count = 0;
        for (int i = index; i >= 0; i--) {
            if (bitArray[i] == 0) {
                return count;
            }
            count++;
        }
        return count;
    }
}
