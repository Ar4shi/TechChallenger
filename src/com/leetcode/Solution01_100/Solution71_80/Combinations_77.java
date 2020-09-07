package com.leetcode.Solution01_100.Solution71_80;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @author jianghan
 * @date 2020-09-08 00:41
 */
public class Combinations_77 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k < 1 || n < k) {
            return result;
        }
        recursion(new ArrayList<>(), n, k);
        return result;
    }

    private void recursion(List<Integer> list, int n, int count) {
        if (count == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                //去重
                if (list.size() > 0 && i > list.get(list.size() - 1)||list.size()==0) {
                    list.add(i);
                    recursion(list, n, count - 1);
                    //回溯
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Combinations_77 combinations_77 = new Combinations_77();
        combinations_77.combine(4, 2);
    }
}
