package com.sword.Solution21_30;

import com.leetcode.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author jianghan
 * @date 2021-03-28 23:27
 */
public class IsSubStructure_26 {
    private boolean result;
    private TreeNode lastNodeB;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        findDfsLastNode(B);
        dfsForEveryTreeNodeA(A, B);
        return result;
    }

    private void dfsForEveryTreeNodeA(TreeNode A, TreeNode B) {
        if (A == null) {
            return;
        }
        //剪枝 节约时间
        if (result) {
            return;
        }
        search(A, B, true);
        dfsForEveryTreeNodeA(A.left, B);
        dfsForEveryTreeNodeA(A.right, B);
    }

    private void search(TreeNode nodeA, TreeNode nodeB, boolean flag) {
        if (!flag) {
            return;
        }
        if (nodeB == null) {
            return;
        }
        //A比B短 显然不可能
        if (nodeA == null) {
            result = false;
            return;
        }
        flag = nodeA.val == nodeB.val;
        if (nodeB == lastNodeB && flag) {
            result = true;
            return;
        }
        search(nodeA.left, nodeB.left, flag);
        search(nodeA.right, nodeB.right, flag);
    }

    private void findDfsLastNode(TreeNode node) {
        if (node == null) {
            return;
        }
        lastNodeB = node;
        findDfsLastNode(node.left);
        findDfsLastNode(node.right);
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(-2);
        TreeNode a = new TreeNode(1);
        rootA.left = a;
        TreeNode rootB = new TreeNode(-2);
        rootB.left = new TreeNode(1);
        rootB.right = new TreeNode(-2);
        IsSubStructure_26 isSubStructure_26 = new IsSubStructure_26();
        System.out.println(isSubStructure_26.isSubStructure(rootA, rootB));
    }
}
