package com.leetcode.Solution101_200.Solution141_150;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author jianghan
 * @date 2020-10-09 00:01
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
