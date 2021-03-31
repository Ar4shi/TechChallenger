package com.sword.Solution31_40;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 *
 * @author jianghan
 * @date 2021-04-01 00:39
 */
public class LevelOrder_32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
