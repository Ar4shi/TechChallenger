package com.leetcode.Solution201_300.Solution201_210;

import java.util.Arrays;

/**
 * 计数质数
 *
 * @author jianghan
 * @date 2020-12-03 23:15
 */
public class CountPrimes_204 {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int count = 0;
        boolean[] array = isPrimes(n);
        for (int i = 2; i < array.length; i++) {
            if(array[i]){
                count+=1;
            }
        }
        return count;
    }

    private boolean[] isPrimes(int n) {
        boolean[] array = new boolean[n];
        Arrays.fill(array, true);
        array[0] = false;
        array[1] = false;
        for (int i = 2; i * i <= n; i++) {
            for (int j = 2; i * j < n; j++) {
                array[i * j] = false;
            }
        }
        return array;
    }
}
