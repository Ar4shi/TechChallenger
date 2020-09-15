package com.leetcode.Solution201_300.Solution221_230;

import com.leetcode.TreeNode;

/**
 * 翻转二叉树
 *
 * @author jianghan
 * @date 2020-09-16 00:01
 */
public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
