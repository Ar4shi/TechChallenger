package com.interview.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 */
public class LegalBinarySearchTree {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        // 这也算我靠
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        dfs(root);
        // 二叉搜索树的中序遍历递增
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

}
