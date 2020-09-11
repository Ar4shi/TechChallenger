package com.leetcode.Solution201_300.Solution201_210;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 *
 * @author jianghan
 * @date 2020-09-11 00:14
 */
public class CombinationSumIII_216 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(1, k, n, new ArrayList<>());
        return result;
    }

    private void recursion(int start, int k, int n, List<Integer> list) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(list));
        }
        if (n <= 0) {
            return;
        }
        if (k > 0) {
            for (int i = start; i < 10; i++) {
                list.add(i);
                recursion(i + 1, k - 1, n - i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII_216 CombinationSumIII_216 = new CombinationSumIII_216();
        CombinationSumIII_216.combinationSum3(3, 9);
    }
}
