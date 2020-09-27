package com.leetcode.Solution201_300.Solution231_240;

import com.leetcode.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author jianghan
 * @date 2020-09-27 00:17
 */
public class LowestCommonAncestorOfABinarySearchTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        Stack<TreeNode> route1 = new Stack<>();
        getRoute(root, route1, p.val);
        Stack<TreeNode> route2 = new Stack<>();
        getRoute(root, route2, q.val);
        if (route1.size() <= route2.size()) {
            while (!route1.isEmpty()) {
                TreeNode curNode = route1.pop();
                if (route2.contains(curNode)) {
                    result = curNode;
                    break;
                }
            }
        } else {
            while (!route2.isEmpty()) {
                TreeNode curNode = route2.pop();
                if (route1.contains(curNode)) {
                    result = curNode;
                    break;
                }
            }
        }
        return result;
    }

    private void getRoute(TreeNode node, Stack<TreeNode> treeNodes, int val) {
        if (node == null) {
            return;
        }
        treeNodes.push(node);
        if (node.val > val) {
            getRoute(node.left, treeNodes, val);
        } else if (node.val < val) {
            getRoute(node.right, treeNodes, val);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree_235 lowestCommonAncestorOfABinarySearchTree_235 = new LowestCommonAncestorOfABinarySearchTree_235();
        TreeNode root = new TreeNode(2);
        TreeNode a = new TreeNode(1);
        root.left = a;
        lowestCommonAncestorOfABinarySearchTree_235.lowestCommonAncestor(root, root, a);
    }
}
