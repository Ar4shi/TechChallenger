package com.leetcode.Solution101_200.Solution111_120;

import com.leetcode.TreeNode;

/**
 * 二叉树的最小深度
 *
 * @author jianghan
 * @date 2021-02-03 23:29
 */
public class MinimumDepthOfBinaryTree_111 {

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return minDepth + 1;
    }

    private void dfs(TreeNode node, int currentDepth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
            return;
        }
        dfs(node.left, currentDepth + 1);
        dfs(node.right, currentDepth + 1);
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree_111 minimumDepthOfBinaryTree_111 = new MinimumDepthOfBinaryTree_111();
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        minimumDepthOfBinaryTree_111.minDepth(root);
    }
}
