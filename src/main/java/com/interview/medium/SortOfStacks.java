package com.interview.medium;

import java.util.Stack;

public class SortOfStacks {

    Stack<Integer> stack;

    Stack<Integer> auxiliaryStack;

    public SortOfStacks() {
        stack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(val);
            return;
        }
        while (!stack.isEmpty()) {
            Integer peek = stack.peek();
            if (peek < val) {
                Integer pop = stack.pop();
                auxiliaryStack.push(pop);
            } else {
                stack.push(val);
                break;
            }
        }
        if (stack.isEmpty()) {
            stack.push(val);
        }
        while (!auxiliaryStack.isEmpty()) {
            stack.push(auxiliaryStack.pop());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortOfStacks sortOfStacks = new SortOfStacks();
        sortOfStacks.push(1);
        sortOfStacks.push(2);
        sortOfStacks.peek();
        sortOfStacks.pop();
        sortOfStacks.peek();
    }
}
