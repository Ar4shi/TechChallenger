package com.leetcode.Solution101_200.Solution131_140;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 *
 * @author jianghan
 * @date 2021-04-10 14:44
 */
public class CopyListWithRandomPointer_138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //<oldNode,newNode>
        Map<Node, Node> map = new HashMap<>();

        Node newHeadNode = new Node(head.val);
        map.put(head, newHeadNode);
        Node currentNode = head.next;

        while (currentNode != null) {
            Node newNode = new Node(currentNode.val);
            map.put(currentNode, newNode);
            currentNode = currentNode.next;
        }
        map.forEach((oldNode, newNode) -> {
            if (oldNode.next != null) {
                newNode.next = map.get(oldNode.next);
            }
            if (oldNode.random != null) {
                newNode.random = map.get(oldNode.random);
            }
        });
        return newHeadNode;
    }
}
