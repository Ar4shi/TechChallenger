package com.leetcode.Solution501_600.Solution531_540;

import com.leetcode.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 *
 * @author jianghan
 * @date 2020-09-21 20:40
 */
public class ConvertBSTToGreaterTree_538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        DFS(root);
        return root;
    }

    private void DFS(TreeNode node) {
        if (node == null) {
            return;
        }
        DFS(node.right);
        sum += node.val;
        node.val = sum;
        DFS(node.left);
    }
}
