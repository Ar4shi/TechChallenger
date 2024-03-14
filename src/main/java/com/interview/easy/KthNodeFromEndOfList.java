package com.interview.easy;

import com.leetcode.ListNode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class KthNodeFromEndOfList {

    public int kthToLast(ListNode head, int k) {
        int count = 1;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            count++;
        }
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        currentNode = virtualHead;
        for (int i = 0; i < count - k + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }
}
