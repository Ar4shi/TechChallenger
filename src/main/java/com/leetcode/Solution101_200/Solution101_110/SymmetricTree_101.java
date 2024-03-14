package com.leetcode.Solution101_200.Solution101_110;

import com.leetcode.TreeNode;

/**
 * 对称二叉树
 *
 * @author jianghan
 * @date 2020-03-05 12:14
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return recursionCheck(root.left,root.right);
    }

    /**
     * 递归方式
     * 左子树的节点值 = 右子树的节点值
     * 左子树的左子树 = 右子树的右子树
     * 左子树的右子树 = 右子树的左子树
     */
    private boolean recursionCheck(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;
        if(leftTree.val == rightTree.val&&recursionCheck(leftTree.left,rightTree.right)&&recursionCheck(leftTree.right,rightTree.left)){
            return true;
        }else {
            return false;
        }
    }
}
