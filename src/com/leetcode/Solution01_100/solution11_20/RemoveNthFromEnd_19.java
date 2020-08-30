package com.leetcode.Solution01_100.solution11_20;

import com.leetcode.ListNode;

/**
 * 删除链表的倒数第N个节点
 *
 * @author jianghan
 * @date 2019-06-27 09:33
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return OnceScan(head, n);
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

    /**
     * 方法2：一次扫描 快慢指针
     */
    private ListNode OnceScan(ListNode head, int n) {
        ListNode slowNode = head;//初始化慢指针
        ListNode fastNode = head;//初始化快指针
        int count = 0;//计数器
        while (count != n) {//移动快指针到使之离慢指针的间距位n
            fastNode = fastNode.next;
            count++;
        }
        if(fastNode==null){//当n = 链表长度时,即删除头节点
            return head.next;
        }
        while(fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }
}
