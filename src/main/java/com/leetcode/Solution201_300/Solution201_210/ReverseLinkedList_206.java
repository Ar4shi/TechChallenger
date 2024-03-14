package com.leetcode.Solution201_300.Solution201_210;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 *
 * @author jianghan
 * @date 2021-03-18 22:34
 */
public class ReverseLinkedList_206 {
    ListNode newHead = null;

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        recursion(head, head.next);
        head.next = null;
        return newHead;
    }

    /**
     * 递归法
     * 每个节点指向它的前一个节点
     */
    private void recursion(ListNode node, ListNode next) {
        if (next == null) {
            this.newHead = node;
            return;
        }
        recursion(node.next, node.next.next);
        next.next = node;
    }


    /**
     * 迭代法
     * 每个节点指向它的前一个节点
     */
    private ListNode iteration(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> content = new ArrayList<>();
        while (head != null) {
            content.add(head);
            head = head.next;
        }
        content.get(0).next = null;
        for (int i = 1; i < content.size(); i++) {
            content.get(i).next = content.get(i - 1);
        }
        return content.get(content.size() - 1);
    }

}
