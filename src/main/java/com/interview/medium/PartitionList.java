package com.interview.medium;

import com.leetcode.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * <p>
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            ListNode next = currentNode.next;
            if (next.val < x) {
                ListNode singleNode = cutAndConnectNode(currentNode, next);
                singleNode.next = virtualNode.next;
                virtualNode.next = singleNode;
            } else {
                currentNode = currentNode.next;
            }
        }

        return virtualNode.next;
    }

    private ListNode cutAndConnectNode(ListNode preNode, ListNode currentNode) {
        preNode.next = currentNode.next;
        currentNode.next = null;
        return currentNode;
    }

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        ListNode listNode = new ListNode(3);
        listNode.buildNext(1).buildNext(2);
        partitionList.partition(listNode, 3);
    }

}
