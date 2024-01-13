package com.Interview.easy;

import com.leetcode.TreeNode;

public class CheckBalance {

    // 最大高度差
    int maxHeightDiff = 0;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return maxHeightDiff <= 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        maxHeightDiff = Math.max(maxHeightDiff, Math.abs(leftHeight - rightHeight));
        return height;
    }
}
