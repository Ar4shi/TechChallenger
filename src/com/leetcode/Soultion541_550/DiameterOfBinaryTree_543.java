package com.leetcode.Soultion541_550;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的直径
 *
 * @author jianghanh
 * @date 2020-03-10 00:31
 */
public class DiameterOfBinaryTree_543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return res;
    }

    /**
     * 遍历每个节点
     * DFS
     */
    private void maxLength(TreeNode root) {
        if (root != null) {
            int length = 0;
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            length = leftDepth+rightDepth;
            res = Math.max(res, length);

            maxLength(root.left);
            maxLength(root.right);
        }
    }

    /**
     * 获取目标二叉树的深度
     * BFS
     */
    private int getDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int rank = 0;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            rank += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return rank;
    }
}
