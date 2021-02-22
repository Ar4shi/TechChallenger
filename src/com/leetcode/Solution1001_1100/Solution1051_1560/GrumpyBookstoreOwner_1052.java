package com.leetcode.Solution1001_1100.Solution1051_1560;

/**
 * 爱生气的书店老板
 *
 * @author jianghan
 * @date 2021-02-23 01:53
 */
public class GrumpyBookstoreOwner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int common = 0;
        int extra = 0;
        //初始化extra和common
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            } else {
                common += customers[i];
            }
        }
        int maxExtra = extra;
        //i的索引代表当前窗口的起点位置
        for (int i = 1; i <= grumpy.length - X; i++) {
            if (grumpy[i - 1] == 1) {
                extra -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                extra += customers[i + X - 1];
            } else {
                common += customers[i + X - 1];
            }
            maxExtra = Math.max(extra, maxExtra);
        }
        return common + maxExtra;
    }

    //超时
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int max = 0;
        for (int i = 0; i <= grumpy.length - X; i++) {
            int temp = 0;
            //窗口前
            for (int j = 0; j < i; j++) {
                if (grumpy[j] == 0) {
                    temp += customers[j];
                }
            }
            //窗口内
            for (int j = 0; j < X; j++) {
                temp += customers[i + j];
            }
            //窗口后
            for (int j = i + X; j < grumpy.length; j++) {
                if (grumpy[j] == 0) {
                    temp += customers[j];
                }
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner_1052 grumpyBookstoreOwner_1052 = new GrumpyBookstoreOwner_1052();
        grumpyBookstoreOwner_1052.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
    }
}
