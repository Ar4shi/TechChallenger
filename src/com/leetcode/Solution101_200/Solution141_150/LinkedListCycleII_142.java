package com.leetcode.Solution101_200.Solution141_150;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * @author jianghan
 * @date 2020-10-10 00:52
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
