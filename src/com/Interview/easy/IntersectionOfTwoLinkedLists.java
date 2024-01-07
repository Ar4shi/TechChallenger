package com.Interview.easy;

import com.leetcode.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currentA = headA;
        while (currentA != null) {
            ListNode currentB = headB;
            while (currentB != null) {
                if (currentA == currentB) {
                    return currentA;
                }
                currentB = currentB.next;
            }
            currentA = currentA.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode headA = new ListNode(4);
        headA.buildNext(1).buildNext(8).buildNext(4).buildNext(5);
        ListNode headB = new ListNode(5);
        headB.buildNext(8).buildNext(1).buildNext(8).buildNext(4).buildNext(5);
        intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);
    }
}
