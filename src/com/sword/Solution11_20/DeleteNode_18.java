package com.sword.Solution11_20;

import com.leetcode.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author jianghan
 * @date 2021-03-24 01:01
 */
public class DeleteNode_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        ListNode preNode = virtualNode;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.val == val) {
                preNode.next = currentNode.next;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        return virtualNode.next;
    }
}
