package com.leetcode.Solution701_800.Solution701_710;

import com.leetcode.TreeNode;

/**
 * 二叉搜索树中的插入操作
 *
 * @author jianghan
 * @date 2020-09-30 00:43
 */
public class InsertIntoABinarySearchTree_701 {
    int val;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        this.val = val;
        insertNode(root, null, 0);
        return root;
    }

    //flag 代表上一个节点的方向 1代表左 2代表右 0代表初始节点是根节点 没有方向
    private void insertNode(TreeNode currentNode, TreeNode parentNode, int flag) {
        if (currentNode == null) {
            if (flag == 1) {
                parentNode.right = new TreeNode(val);
            } else {
                parentNode.left = new TreeNode(val);
            }
            return;
        }
        if (val > currentNode.val) {
            insertNode(currentNode.right, currentNode, 1);
        } else {
            insertNode(currentNode.left, currentNode, 2);
        }
    }
}
