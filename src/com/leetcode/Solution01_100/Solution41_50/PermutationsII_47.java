package com.leetcode.Solution01_100.Solution41_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 *
 * @author jianghan
 * @date 2020-09-18 00:10
 */
public class PermutationsII_47 {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        recursion(new boolean[nums.length], new ArrayList<>());
        return result;
    }

    private void recursion(boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果当前索引的这个数已经被用过,跳过
            if (visited[i]) {
                continue;
            }
            // !visited[i - 1] 代表前面一个相同的数字未被使用过
            // 如果在同一个递归树中,前面一个相同的数字必先于当前索引被使用
            // 故 !visited[i - 1] 代表以当前索引指向的数字开始的一轮新的递归树,而前一个相同的数字必先于此索引被深度遍历完,所以剪掉此递归
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            recursion(visited, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 permutationsII_47 = new PermutationsII_47();
        permutationsII_47.permuteUnique(new int[]{1,1,2});
    }
}
