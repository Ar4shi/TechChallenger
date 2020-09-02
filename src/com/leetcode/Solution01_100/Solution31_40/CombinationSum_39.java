package com.leetcode.Solution01_100.Solution31_40;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 *
 * @author jianghan
 * @date 2020-02-05 14:52
 */
public class CombinationSum_39 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            list.add(candidates[i]);
            recursion(i, candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 combinationSum_39 = new CombinationSum_39();
        combinationSum_39.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
