package com.leetcode.Solution1501_1600.Solution1531_1540;

import java.util.Arrays;

/**
 * 最小的k个数
 *
 * @author jianghan
 * @date 2020-03-20 09:24
 */
public class LeastNumbers_1538 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = arr[i];
        }
        return res;
    }
}
