package com.leetcode.Solution401_500.Solution401_410;

import com.leetcode.TreeNode;

/**
 * 左叶子之和
 *
 * @author jianghan
 * @date 2020-09-19 00:40
 */
public class SumOfLeftLeaves_404 {
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        DFS(root, 0);
        return result;
    }

    // state = 0 root
    // state = 1 left
    // state = 0 right
    private void DFS(TreeNode node, int state) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && state == 1) {
            result += node.val;
        }
        DFS(node.left, 1);
        DFS(node.right, 2);
    }
}
