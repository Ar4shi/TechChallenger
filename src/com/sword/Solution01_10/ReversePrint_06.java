package com.sword.Solution01_10;

import com.leetcode.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author jianghan
 * @date 2021-03-20 15:42
 */
public class ReversePrint_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ReversePrint_06 reversePrint_06 = new ReversePrint_06();
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        root.next = a;
        a.next = b;
        reversePrint_06.reversePrint(root);
    }
}
