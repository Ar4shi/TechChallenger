package com.sword.Solution31_40;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * @author jianghan
 * @date 2021-04-07 23:49
 */
public class TreeToDoublyList_36 {
    List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        dfs(root);
        if (list.size() == 0) {
            return root;
        } else if (list.size() == 1) {
            //自旋
            root.left = root;
            root.right = root;
            return root;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (i != 0) {
                list.get(i).left = list.get(i - 1);
            }
            list.get(i).right = list.get(i + 1);
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        list.get(list.size() - 1).right = list.get(0);
        return list.get(0);
    }

    /**
     * AVL树中序遍历递增
     */
    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        TreeToDoublyList_36 treeToDoublyList_36 = new TreeToDoublyList_36();
        Node root = new Node(4);
        Node a = new Node(2);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(3);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        treeToDoublyList_36.treeToDoublyList(root);
    }
}
