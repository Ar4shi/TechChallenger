package com.leetcode.Solution601_700.Solution671_680;

import com.leetcode.TreeNode;

/**
 * 合并二叉树
 *
 * @author jianghan
 * @date 2020-09-23 00:52
 */
public class MergeTwoBinaryTrees_671 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode node = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
}
