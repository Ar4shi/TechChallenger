package com.leetcode.Solution01_100.solution21_30;

import com.leetcode.ListNode;

/**
 * 合并两个有序链表
 *
 * @author jianghan
 * @date 2019-06-27 15:36
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return recursiveMerge(l1, l2);
    }

    /**
     * 迭代方法
     */
    private ListNode IterateMerge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(1);//新建一个链表用于存储
        ListNode current = result;//链表指针
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return result.next;
    }

    /**
     * 递归方法
     */
    private ListNode recursiveMerge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = recursiveMerge(l1.next, l2);
            return l1;
        } else {
            l2.next = recursiveMerge(l1, l2.next);
            return l2;
        }
    }
}
