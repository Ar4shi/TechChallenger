package com.Interview.easy;

import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 */
public class ImplementQueueUsingStacks {

    Stack<Integer> inputStack;

    Stack<Integer> outputStack;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!outputStack.isEmpty()) {
            inputStack.push(outputStack.pop());
        }
        inputStack.push(x);
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return outputStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return outputStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return outputStack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks implementQueueUsingStacks = new ImplementQueueUsingStacks();
        implementQueueUsingStacks.push(1);
        implementQueueUsingStacks.push(2);
        implementQueueUsingStacks.peek();
        implementQueueUsingStacks.pop();
        System.out.println(implementQueueUsingStacks.empty());
    }
}
