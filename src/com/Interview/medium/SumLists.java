package com.Interview.medium;

import com.leetcode.ListNode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class SumLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode virtualNode = new ListNode(0);
        boolean flag = false;
        int firstValue = l1.val + l2.val;
        if (firstValue >= 10) {
            flag = true;
            firstValue = firstValue - 10;
        }
        ListNode resultNode = new ListNode(firstValue);
        virtualNode.next = resultNode;
        while (l1.next != null || l2.next != null) {
            int value = 0;
            if (l1.next != null) {
                value += l1.next.val;
                l1.next = l1.next.next;
            }
            if (l2.next != null) {
                value += l2.next.val;
                l2.next = l2.next.next;
            }
            if (flag) {
                value += 1;
            }
            if (value >= 10) {
                flag = true;
                value = value - 10;
            } else {
                flag = false;
            }
            resultNode.next = new ListNode(value);
            resultNode = resultNode.next;
        }
        if (flag) {
            resultNode.next = new ListNode(1);
        }
        return virtualNode.next;
    }

    public static void main(String[] args) {
        SumLists sumLists = new SumLists();
        sumLists.addTwoNumbers(new ListNode(5), new ListNode(5));
    }
}
