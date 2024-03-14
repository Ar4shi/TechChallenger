package com.leetcode.Solution101_200.Solution111_120;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @author jianghan
 * @date 2020-10-15 00:22
 */
public class PopulatingNextRightPointersInEachNode_116 {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<Node>() {{
            this.add(root);
        }};
        int currentSize = 1;
        int remain = 1;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            Node nextNode = queue.peek();
            if (remain > 1) {
                currentNode.next = nextNode;
            }
            remain -= 1;
            if (remain == 0) {
                currentSize *= 2;
                remain = currentSize;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
