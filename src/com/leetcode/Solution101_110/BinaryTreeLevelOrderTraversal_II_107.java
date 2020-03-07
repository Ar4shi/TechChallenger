package com.leetcode.Solution101_110;

import com.leetcode.TreeNode;
import javafx.scene.shape.ClosePathBuilder;

import java.util.*;

/**
 * 二叉树的层次遍历 II
 *
 * @author jianghanh
 * @date 2020-03-07 15:30
 */
public class BinaryTreeLevelOrderTraversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return BFS(root);
    }

    /**
     * 广度优先遍历层级
     * 然后转置
     */
    private List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                temp.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            stack.add(temp);
        }
        while (!stack.isEmpty()) res.add(stack.pop());
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal_II_107 binaryTreeLevelOrderTraversal_II_107 = new BinaryTreeLevelOrderTraversal_II_107();

        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);

        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        binaryTreeLevelOrderTraversal_II_107.levelOrderBottom(root);
    }
}
