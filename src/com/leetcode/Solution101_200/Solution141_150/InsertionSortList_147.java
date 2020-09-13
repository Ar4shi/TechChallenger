package com.leetcode.Solution101_200.Solution141_150;

import com.leetcode.ListNode;

import java.security.AlgorithmConstraints;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对链表进行插入排序
 *
 * @author jianghan
 * @date 2020-09-12 23:14
 */
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head, cur = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (cur != null) {
            if (pre.val < cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                while (p.next != cur && p.next.val < cur.val)
                    p = p.next;
                //删除当前节点
                pre.next = cur.next;
                //将当前节点连接到对应位置
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        root.next = a;
        a.next = b;
        b.next = c;
        InsertionSortList_147 insertionSortList_147 = new InsertionSortList_147();
        insertionSortList_147.insertionSortList(root);
    }
}
