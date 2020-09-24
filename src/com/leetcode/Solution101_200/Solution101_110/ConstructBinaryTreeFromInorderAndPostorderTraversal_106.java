package com.leetcode.Solution101_200.Solution101_110;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author jianghan
 * @date 2020-09-25 00:23
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, length - 1, map, 0, length - 1);
    }

    private TreeNode buildTree(int[] postorder, int posleft, int posright, Map<Integer, Integer> map, int inleft, int inright) {
        if (posleft > posright) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[posright]);
        node.left = buildTree(postorder, posleft, map.get(postorder[posright]) - 1 - inleft + posleft, map, inleft, map.get(postorder[posright]) - 1);
        node.right = buildTree(postorder, map.get(postorder[posright]) - inleft + posleft, posright - 1, map, map.get(postorder[posright]) + 1, inright);
        return node;
    }
}
