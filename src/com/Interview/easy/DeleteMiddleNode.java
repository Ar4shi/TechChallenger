package com.Interview.easy;

import com.leetcode.ListNode;

public class DeleteMiddleNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
