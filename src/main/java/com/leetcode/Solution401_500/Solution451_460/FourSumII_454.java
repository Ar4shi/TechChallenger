package com.leetcode.Solution401_500.Solution451_460;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 *
 * @author jianghan
 * @date 2020-11-27 23:28
 */
public class FourSumII_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    int newCount = map.get(sum) + 1;
                    map.put(sum, newCount);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(sum * (-1))) {
                    count += map.get(sum * (-1));
                }
            }
        }
        return count;
    }
}
