package com.leetcode.Solution101_200.Solution131_140;

/**
 * 加油站
 *
 * @author jianghan
 * @date 2020-09-24 01:30
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int[] remain = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            remain[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < remain.length; i++) {
            if (remain[i] < 0) {
                continue;
            }
            int flag = 0;
            for (int j = i; j < i + remain.length; j++) {
                if (j >= remain.length) {
                    if (flag + remain[j - remain.length] < 0) {
                        break;
                    } else {
                        flag += remain[j - remain.length];
                    }
                } else {
                    if (flag + remain[j] < 0) {
                        break;
                    } else {
                        flag += remain[j];
                    }
                }
                if (j == i + remain.length - 1) {
                    return i;
                }
            }
        }
        return res;
    }
}
