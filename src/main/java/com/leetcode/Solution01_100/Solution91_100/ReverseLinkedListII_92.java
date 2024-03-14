package com.leetcode.Solution01_100.Solution91_100;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表 II
 *
 * @author jianghan
 * @date 2021-03-18 19:58
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        return iteration(head, m, n);
    }

    /**
     * 迭代法
     * 每个节点指向它的前一个节点
     * 头尾节点改变指向
     *
     * 就嗯写 嗯调试 超过100% 晚点去看看其他算法
     */
    private ListNode iteration(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        List<ListNode> content = new ArrayList<>();
        while (head != null) {
            content.add(head);
            head = head.next;
        }
        for (int i = m; i < n; i++) {
            content.get(i).next = content.get(i - 1);
        }
        if (n < content.size()) {
            content.get(m - 1).next = content.get(n);
        } else {
            content.get(m - 1).next = null;
        }
        if (m == 1) {
            return content.get(n - 1);
        }
        if (m - 2 >= 0) {
            content.get(m - 2).next = content.get(n - 1);
        } else {
            content.get(0).next = null;
            return content.get(content.size() - 1);
        }
        return content.get(0);
    }

    public static void main(String[] args) {
        ReverseLinkedListII_92 reverseLinkedListII_92 = new ReverseLinkedListII_92();
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        root.next = a;
        a.next = b;
        reverseLinkedListII_92.reverseBetween(root, 1, 2);
    }
}
