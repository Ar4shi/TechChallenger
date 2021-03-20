package com.sword.Solution01_10;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author jianghan
 * @date 2021-03-21 00:06
 */
public class CQueue_09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue_09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    //把stack1中的元素全部丢到stack2中就能找到队列头的元素了
    //移除即可
    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return -1;
    }
}
