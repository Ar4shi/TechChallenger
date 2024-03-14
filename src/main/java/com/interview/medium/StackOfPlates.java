package com.interview.medium;

import java.util.Stack;

public class StackOfPlates {

    private Stack<Stack<Integer>> stackList;

    private final int cap;

    public StackOfPlates(int cap) {
        stackList = new Stack<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        if (stackList.size() == 0) {
            Stack<Integer> stack = new Stack<>();
            stackList.push(stack);
        }
        Stack<Integer> currentStack = stackList.peek();
        if (currentStack.size() < cap) {
            currentStack.push(val);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            stackList.add(stack);
        }
    }

    public int pop() {
        if (stackList.size() == 0) {
            return -1;
        }
        Stack<Integer> currentStack = stackList.peek();
        Integer pop = currentStack.pop();
        if (currentStack.size() == 0) {
            stackList.pop();
        }
        return pop;
    }

    public int popAt(int index) {
        if (index >= stackList.size()) {
            return -1;
        }
        Stack<Integer> stack = stackList.get(index);
        Integer pop = stack.pop();
        if (stack.size() == 0) {
            stackList.remove(stack);
        }
        return pop;
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(1);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.popAt(1);
        stackOfPlates.pop();
        stackOfPlates.pop();
    }
}
