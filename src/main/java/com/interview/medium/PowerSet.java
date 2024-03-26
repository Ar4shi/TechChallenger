package com.interview.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class PowerSet {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int index) {
        result.add(new ArrayList<>(path));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1);
            // 弹出当前循环的数字
            path.remove(path.size() - 1);
        }
    }
}
