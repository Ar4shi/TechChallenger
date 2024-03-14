package com.leetcode.Solution01_100.Solution71_80;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author jianghan
 * @date 2020-09-20 00:19
 */
public class Subsets_78 {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        // total 层
        for (int i = 1; i <= nums.length; i++) {
            recursion(-1, i, new ArrayList<>());
        }
        return result;
    }

    private void recursion(int index, int total, List<Integer> list) {
        if (list.size() == total) {
            result.add(new ArrayList<>(list));
            return;
        }
        //index 层
        for (int j = 0; j < nums.length; j++) {
            if (j > index) {
                list.add(nums[j]);
                recursion(j, total, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        subsets_78.subsets(new int[]{1, 2, 3});
    }
}
