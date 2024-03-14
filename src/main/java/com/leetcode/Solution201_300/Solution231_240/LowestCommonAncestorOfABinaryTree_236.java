package com.leetcode.Solution201_300.Solution231_240;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 *
 * @author jianghan
 * @date 2020-12-13 18:49
 */
public class LowestCommonAncestorOfABinaryTree_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    /**
     * 两次DFS 然后比较链表
     * 很慢很慢很慢很慢很慢
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        List<List<TreeNode>> result1 = new ArrayList<>();
        List<List<TreeNode>> result2 = new ArrayList<>();
        findList(root, p, new ArrayList<>(), result1);
        findList(root, q, new ArrayList<>(), result2);
        for (TreeNode node : result1.get(0)) {
            for (TreeNode node2 : result2.get(0)) {
                if (node.val == node2.val) {
                    result = node;
                }
            }
        }
        return result;
    }

    private void findList(TreeNode node, TreeNode p, List<TreeNode> content, List<List<TreeNode>> result) {
        if (node == null) {
            return;
        }
        content.add(node);
        if (node.val == p.val) {
            result.add(new ArrayList<>(content));
            return;
        }
        findList(node.left, p, content, result);
        findList(node.right, p, content, result);
        content.remove(content.size() - 1);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree_236 lowestCommonAncestorOfABinaryTree_236 = new LowestCommonAncestorOfABinaryTree_236();
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(0);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        d.right = h;
        lowestCommonAncestorOfABinaryTree_236.lowestCommonAncestor(root, c, h);
    }
}
