package com.leetcode.Solution201_300.Solution221_230;

import com.leetcode.TreeNode;

/**
 * 完全二叉树的节点个数
 *
 * @author jianghan
 * @date 2020-11-24 00:11
 */
public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
