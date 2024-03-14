package com.sword.Solution31_40;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * @author jianghan
 * @date 2021-04-10 13:09
 */
public class PathSum_34 {

    private List<List<Integer>> result = new ArrayList<>();
    private int targe;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.targe = target;
        dfs(root, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> list, int sum) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.val + sum == this.targe && node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
        }
        dfs(node.left, list, sum + node.val);
        dfs(node.right, list, sum + node.val);
        list.remove(list.size() - 1);
    }
}
