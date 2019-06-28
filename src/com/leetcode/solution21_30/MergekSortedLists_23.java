package com.leetcode.solution21_30;

import com.leetcode.ListNode;

/**
 * 合并K个排序链表
 *
 * @author jianghanh
 * @date 2019-06-28 09:27
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return function_01(lists);
    }

    /**
     * 方法一：逐一两两合并
     * 每次合并都需要扫描两个两个链表（上一个合并过的字符串和新的字符串）
     * 存在重复扫描 时间复杂度较高
     */
    private ListNode function_01(ListNode[] lists){
        if(lists.length==0){return null;}
        if(lists.length==1){return lists[0];}
        ListNode resultNode = IterateMerge(lists[0],lists[1]);
        if(lists.length==2){return resultNode;}
        for(int i = 2 ;i<lists.length;i++){
            resultNode = IterateMerge(lists[i],resultNode);
        }
        return resultNode;
    }

    /**
     * 方法二：二分法进行两两合并
     * 方法一的优化 减少重复扫描的元素 优化时间复杂度
     */
    private ListNode function_02(ListNode[] lists){
        return null;
    }
    /**
     * 迭代方式 合并两个有序链表
     * @return
     */
    private ListNode IterateMerge (ListNode l1,ListNode l2){
        ListNode mergedNode = new ListNode(0);
        ListNode currentNode = mergedNode;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                currentNode.next = l1;
                currentNode = currentNode.next;
                l1 = l1.next;
            }else{
                currentNode.next = l2;
                currentNode = currentNode.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            currentNode.next = l2;
        }else {
            currentNode.next = l1;
        }
        return mergedNode.next;
    }
}
