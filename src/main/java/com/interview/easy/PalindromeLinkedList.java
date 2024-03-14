package com.interview.easy;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            list.add(head.next.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            int j = list.size() - i - 1;
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);
        System.out.println(integer1.equals(integer2));
    }
}
