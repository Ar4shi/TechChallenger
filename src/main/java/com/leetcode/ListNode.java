package com.leetcode;

/**
 * 链表类
 *
 * @author jianghan
 * @date 2019-06-27 10:08
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode current;

    public ListNode(int x) {
        val = x;
        current = this;
    }

    public ListNode(Integer[] nums) {
        ListNode currNode = this;
        currNode.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currNode.next = new ListNode(nums[i]);
            currNode = currNode.next;
        }
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode currNode = this;
        StringBuilder s = new StringBuilder();
        while (currNode != null) {
            s.append(currNode.val);
            s.append(" -> ");
            currNode = currNode.next;
        }
        // 最后添加一个 NULL 标志表示添加到末尾了
        s.append("NULL");
        System.out.println(s.toString());
        return s.toString();
    }

    /**
     * 链式构建
     */
    public ListNode buildNext(int nextValue) {
        ListNode next = new ListNode(nextValue);
        current.next = next;
        return current.next;
    }

    /**
     * 将链表中的某个节点切出来返回，并将连接原始链表
     */
    private ListNode cutAndConnectNode(ListNode preNode, ListNode currentNode) {
        preNode.next = currentNode.next;
        currentNode.next = null;
        return currentNode;
    }
}
