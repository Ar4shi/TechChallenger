package com.leetcode.Solution1101_1200.Solution1121_1130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组的相对排序
 *
 * @author jianghan
 * @date 2020-11-14 22:20
 */
public class RelativeSortArray_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[arr1.length];
        boolean[] flag = new boolean[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    list.add(arr1[j]);
                    flag[j] = true;
                }
            }
        }
        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                remain.add(arr1[i]);
            }
        }
        Integer[] integers = remain.toArray(new Integer[0]);
        Arrays.sort(integers);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        for (int i = list.size(); i < arr1.length; i++) {
            res[i] = integers[i - list.size()];
        }
        return res;
    }
}
