package com.Interview.easy;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class RemoveDuplicateNode {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicateNode removeDuplicateNode = new RemoveDuplicateNode();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        removeDuplicateNode.removeDuplicateNodes(head);
    }
}
