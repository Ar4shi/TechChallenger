package com.leetcode.Solution301_400.Solution381_390;

import com.leetcode.ListNode;

import java.util.*;

/**
 * 链表随机节点
 *
 * @author jianghan
 * @date 2022-01-17 01:58
 */
public class LinkedListRandomNode_382 {

    List<Integer> list;
    Random random;

    public LinkedListRandomNode_382(ListNode head) {
        list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        LinkedListRandomNode_382 linkedListRandomNode_382 = new LinkedListRandomNode_382(a);
        System.out.println(linkedListRandomNode_382.getRandom());
        System.out.println(linkedListRandomNode_382.getRandom());
        System.out.println(linkedListRandomNode_382.getRandom());
        System.out.println(linkedListRandomNode_382.getRandom());
        System.out.println(linkedListRandomNode_382.getRandom());
    }
}
