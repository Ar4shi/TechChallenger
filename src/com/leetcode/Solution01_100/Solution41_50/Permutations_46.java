package com.leetcode.Solution01_100.Solution41_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author jianghan
 * @date 2020-02-05 15:53
 */
public class Permutations_46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length <= 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        recursion(list, new ArrayList<>());
        return result;
    }

    private void recursion(List<Integer> remainlist, List<Integer> resultList) {
        if (remainlist.size() == 0) {
            //由于list是引用类型 需要一个新的容器接收
            result.add(new ArrayList<>(resultList));
        }
        for (int i = 0; i < remainlist.size(); i++) {
            resultList.add(remainlist.get(i));
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < remainlist.size(); j++) {
                if (j != i) {
                    list.add(remainlist.get(j));
                }
            }
            recursion(list, resultList);
            //此处回溯
            resultList.remove(resultList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations_46 permutations_46 = new Permutations_46();
        permutations_46.permute(new int[]{1, 2, 3});
    }
}
