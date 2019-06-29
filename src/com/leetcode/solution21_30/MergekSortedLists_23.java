package com.leetcode.solution21_30;

import com.leetcode.ListNode;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 *
 * @author jianghanh
 * @date 2019-06-28 09:27
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){return null;}
        return function_02(lists,0,lists.length-1);
    }

    /**
     * 方法一：逐一两两合并
     * 每次合并都需要扫描两个两个链表（上一个合并过的字符串和新的字符串）
     * 存在重复扫描 时间复杂度较高
     */
    private ListNode function_01(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode resultNode = IterateMerge(lists[0], lists[1]);
        if (lists.length == 2) {
            return resultNode;
        }
        for (int i = 2; i < lists.length; i++) {
            resultNode = IterateMerge(lists[i], resultNode);
        }
        return resultNode;
    }

    /**
     * 方法二：二分法进行两两合并
     * 方法一的优化 减少重复扫描的元素 优化时间复杂度
     */
    private ListNode function_02(ListNode[] lists,int left,int right) {
        if(left==right){return lists[left];}//二分法递归函数出口
        int mid = left+(right-left)/2;
        ListNode l1 = function_02(lists,left,mid);
        ListNode l2 = function_02(lists,mid+1,right);
        return IterateMerge(l1,l2);
    }

    /**
     * 方法三: 优先队列筛选法
     * 时间复杂度同 方法二
     * JAVA8 以上可用lambda表达式
     */
    private ListNode function_03(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val > o2.val) {
                return 1;
            } else if (o1.val == o2.val) {
                return 0;
            } else {
                return -1;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        ListNode resultNode = new ListNode(0);
        ListNode currentNode = resultNode;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();//获得val值最小的链表
            currentNode.next = minNode;
            if(minNode.next!=null){
                queue.add(minNode.next);//重新放入优先队列
            }
            currentNode = currentNode.next;
        }
        return resultNode.next;
    }

    /**
     * 迭代方式 合并两个有序链表
     *
     * @return
     */
    private ListNode IterateMerge(ListNode l1, ListNode l2) {
        ListNode mergedNode = new ListNode(0);
        ListNode currentNode = mergedNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                currentNode = currentNode.next;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                currentNode = currentNode.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            currentNode.next = l2;
        } else {
            currentNode.next = l1;
        }
        return mergedNode.next;
    }
}
