package com.leetcode.Solution101_200.Solution141_150;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 *
 * @author jianghan
 * @date 2020-10-20 00:42
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        int size = 0;
        ListNode curNode = head;
        while (curNode != null) {
            size++;
            list.add(curNode);
            curNode = curNode.next;
        }
        int left = 0;
        int right = size - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
        head = list.get(0);
    }

    public static void main(String[] args) {
        ReorderList_143 reorderList_143 = new ReorderList_143();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        reorderList_143.reorderList(list);
    }
}
