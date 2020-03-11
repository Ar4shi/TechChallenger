package com.leetcode.Solution101_200.Solution101_110;

import com.leetcode.TreeNode;

/**
 * 平衡二叉树
 *
 * @author jianghanh
 * @date 2020-03-09 14:55
 */
public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        d.left = f;
        e.right = g;
        System.out.println(new BalancedBinaryTree_110().isBalanced(a));
    }
}
