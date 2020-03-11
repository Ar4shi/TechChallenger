package com.leetcode.Solution101_200.Solution101_110;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 *
 * @author jianghanh
 * @date 2020-03-05 14:03
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return BFS(root);
    }

    /**
     * 广度优先遍历 BFS
     * 迭代方式
     */
    private List<List<Integer>> BFS(TreeNode root) {
        //记录层级
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rootRank = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            //控制同一层级循环次数
            int round = queue.size();
            List<Integer> curRank = new ArrayList<>();
            for (int i = 0; i < round; i++) {
                TreeNode node = queue.poll();
                curRank.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(curRank);
        }
        return res;
    }

}
