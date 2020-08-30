package com.leetcode.Solution01_100.solution21_30;

import com.leetcode.ListNode;

import java.util.Stack;

/**
 * K 个一组翻转链表
 *
 * @author jianghan
 * @date 2019-06-29 16:29
 */
public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        return function_01(head, k);
    }

    /**
     * 方法一 ： 递归
     * 出口：剩余节点数效于K
     * 返回值：出口返回值：由于节点数不足K返回正序链表  递归单元返回值：逆序过后的链表
     * 递归单元 完成链表逆序
     */
    private ListNode function_01(ListNode head, int k) {
        int count = 0;//计算剩余节点数，判断是否已经到递归的出口
        ListNode currentNode = head;//递归单元的当前节点指针
        ListNode resultNode = new ListNode(0);
        ListNode currentResultNode = resultNode;//返回值的当前节点指针
        Stack<ListNode> stack = new Stack<>();//用于倒置链表的节点容器
        while (currentNode != null && count < k) {
            stack.push(currentNode);
            currentNode = currentNode.next;
            count++;
        }
        if (count < k) {
            return head;
        }//出口
        for (int i = 0; i < k; i++) {
            currentResultNode.next = stack.pop();
            currentResultNode = currentResultNode.next;
        }
        currentResultNode.next = function_01(currentNode, k);
        return resultNode.next;//递归单元返回值
    }
}
