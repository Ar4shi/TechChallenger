package com.leetcode.Solution101_200.Solution141_150;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存机制
 *
 * @author jianghan
 * @date 2021-01-10 21:38
 */
public class LRUCache_146 {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache_146(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        tail.preNode = head;
        head.nextNode = tail;
    }

    /**
     * 1、获取到缓存的值
     * 2、将所取的节点移动到队列头部
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 1、添加到缓存cache中,
     * 2、添加到队列头部
     * 3、如果队列已满,删除
     */
    public void put(int key, int value) {
        //如果存在,则替换当前值
        if (this.get(key) != -1) {
            Node existNode = cache.get(key);
            existNode.value = value;
            //这个return折磨了我一个小时
            return;
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        moveToHead(node);
        if (cache.size() > this.capacity) {
            Node lastNode = tail.preNode;
            tail.preNode = lastNode.preNode;
            lastNode.preNode.nextNode = tail;
            cache.remove(lastNode.key);
        }
    }

    private void moveToHead(Node node) {
        //node 前后节点互相关联,如果node为新生节点则没有前后节点
        if (node.nextNode != null) {
            node.nextNode.preNode = node.preNode;
            node.preNode.nextNode = node.nextNode;
        }
        //node转移至队列头部
        node.nextNode = head.nextNode;
        node.preNode = head;
        head.nextNode.preNode = node;
        head.nextNode = node;
    }

    /**
     * 双向链表的结点
     * 数据实际存储在节点中
     */
    class Node {
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer key;
        public Integer value;
        public Node preNode;
        public Node nextNode;
    }

    public static void main(String[] args) {
        LRUCache_146 lRUCache_146 = new LRUCache_146(10);
        lRUCache_146.put(10, 13);
        lRUCache_146.put(3, 17);
        lRUCache_146.put(6, 11);
        lRUCache_146.put(10, 5);
        lRUCache_146.put(9, 10);
        System.out.println(lRUCache_146.get(13));
        lRUCache_146.put(2, 19);
        System.out.println(lRUCache_146.get(2));
        System.out.println(lRUCache_146.get(3));
        lRUCache_146.put(5, 25);
        System.out.println(lRUCache_146.get(8));
        lRUCache_146.put(9, 22);
        lRUCache_146.put(5, 5);
        lRUCache_146.put(1, 30);
        System.out.println(lRUCache_146.get(11));
        lRUCache_146.put(9, 12);
        System.out.println(lRUCache_146.get(7));
        System.out.println(lRUCache_146.get(5));
        System.out.println(lRUCache_146.get(8));
        System.out.println(lRUCache_146.get(9));
        lRUCache_146.put(4, 30);
        lRUCache_146.put(9, 3);
        System.out.println(lRUCache_146.get(9));
        System.out.println(lRUCache_146.get(10));
        System.out.println(lRUCache_146.get(10));
        lRUCache_146.put(6, 14);
        lRUCache_146.put(3, 1);
        System.out.println(lRUCache_146.get(3));
        lRUCache_146.put(10, 11);
        System.out.println(lRUCache_146.get(8));
        lRUCache_146.put(2, 14);
        System.out.println(lRUCache_146.get(1));
        System.out.println(lRUCache_146.get(5));
        System.out.println(lRUCache_146.get(4));
        lRUCache_146.put(11, 4);
        lRUCache_146.put(12, 24);
        lRUCache_146.put(5, 18);
        System.out.println(lRUCache_146.get(13));
        lRUCache_146.put(7, 23);
        System.out.println(lRUCache_146.get(8));
        System.out.println(lRUCache_146.get(12));
        lRUCache_146.put(3, 27);
        lRUCache_146.put(2, 12);
        System.out.println(lRUCache_146.get(5));
        lRUCache_146.put(2, 9);
        lRUCache_146.put(13, 4);
        lRUCache_146.put(8, 18);
        lRUCache_146.put(1, 7);
        System.out.println(lRUCache_146.get(6));
    }
}
