package com.leetcode.Solution01_100.Solution31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 *
 * @author jianghan
 * @date 2020-09-10 00:26
 */
public class CombinationSumII_40 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void recursion(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            // 【每一轮次的搜索】 若当前值 = 上一个值则抛弃 就能避免重复
            if (i == start) {
                list.add(candidates[i]);
                recursion(i + 1, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            } else {
                if (candidates[i] != candidates[i - 1]) {
                    list.add(candidates[i]);
                    recursion(i + 1, candidates, target - candidates[i], list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII_40 combinationSumII_40 = new CombinationSumII_40();
        combinationSumII_40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }
}
