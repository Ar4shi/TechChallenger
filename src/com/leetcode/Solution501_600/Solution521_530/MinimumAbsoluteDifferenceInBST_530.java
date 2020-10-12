package com.leetcode.Solution501_600.Solution521_530;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最小绝对差
 *
 * @author jianghan
 * @date 2020-10-12 23:16
 */
public class MinimumAbsoluteDifferenceInBST_530 {
    int min = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        midOrderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    //二叉搜索树中序遍历从小到大排列
    private void midOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraversal(node.left);
        list.add(node.val);
        midOrderTraversal(node.right);
    }
}
