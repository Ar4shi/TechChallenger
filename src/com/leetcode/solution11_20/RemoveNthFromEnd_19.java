package com.leetcode.solution11_20;

import com.leetcode.ListNode;

/**
 * 请输入类注释
 *
 * @author jianghanh
 * @date 2019-06-27 09:33
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return twiceScan(head, n);
    }

    /**
     * 方法1：两次扫描 第一次获得长度,第二次删除节点
     */
    public ListNode twiceScan(ListNode head, int n) {
        ListNode currentNode = head;
        int count = 0;//计数器
        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        int cutPoint = count - n + 1;//计算切点位置
        currentNode = head; //重新初始化
        count = 1;//计数器也初始化
        if (cutPoint == 1) {//头节点单独讨论
            return head.next;
        } else {//其他节点
            while (count != cutPoint - 1) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = currentNode.next.next;//去除尾节点
            return head;
        }
    }
}
