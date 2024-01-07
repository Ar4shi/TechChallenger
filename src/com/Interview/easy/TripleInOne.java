package com.Interview.easy;

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
public class TripleInOne {

    private int[][] matrix;

    private int size;

    private int currentIndex0 = -1;
    private int currentIndex1 = -1;
    private int currentIndex2 = -1;

    public TripleInOne(int stackSize) {
        this.size = stackSize;
        this.matrix = new int[3][stackSize];
    }

    public void push(int stackNum, int value) {
        if (stackNum == 0 && currentIndex0 < size - 1) {
            matrix[stackNum][++currentIndex0] = value;
        } else if (stackNum == 1 && currentIndex1 < size - 1) {
            matrix[stackNum][++currentIndex1] = value;
        } else if (stackNum == 2 && currentIndex2 < size - 1) {
            matrix[stackNum][++currentIndex2] = value;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        if (stackNum == 0) {
            return matrix[stackNum][currentIndex0--];
        } else if (stackNum == 1) {
            return matrix[stackNum][currentIndex1--];
        } else {
            return matrix[stackNum][currentIndex2--];
        }
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        if (stackNum == 0) {
            return matrix[stackNum][currentIndex0];
        } else if (stackNum == 1) {
            return matrix[stackNum][currentIndex1];
        } else {
            return matrix[stackNum][currentIndex2];
        }
    }

    public boolean isEmpty(int stackNum) {
        if (stackNum == 0) {
            return currentIndex0 == -1;
        } else if (stackNum == 1) {
            return currentIndex1 == -1;
        } else {
            return currentIndex2 == -1;
        }
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0, 1);
    }
}
