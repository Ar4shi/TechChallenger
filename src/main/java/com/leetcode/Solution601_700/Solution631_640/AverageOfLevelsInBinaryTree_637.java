package com.leetcode.Solution601_700.Solution631_640;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 *
 * @author jianghan
 * @date 2020-09-12 02:28
 */
public class AverageOfLevelsInBinaryTree_637 {
    List<Double> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        BFS(root);
        return result;
    }

    private void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                sum += currentNode.val;
            }
            result.add(sum / size);
        }
    }
}
