package com.leetcode.Solution01_100.solution21_30;

import com.leetcode.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author jianghan
 * @date 2019-06-29 14:13
 */
public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        return Recursive(head);
    }

    /**
     * function01 递归
     * 出口：head为空 或 head.next为空即只有头无尾不需要交换
     * 返回值：完成节点交换的链表
     * 递归单元需要做的事：相邻的两个节点交换
     */
    private ListNode Recursive(ListNode head) {
        if (head == null || head.next == null) {//出口
            return head;//返回值：完成节点交换的链表
        }
        ListNode next = head.next;
        head.next = Recursive(next.next);
        next.next = head;
        return next;//返回值：完成节点交换的链表 由于next与head呼唤位置，所以此刻next才是头节点
    }
}
