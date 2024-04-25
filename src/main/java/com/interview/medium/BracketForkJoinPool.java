package com.interview.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Bracket题目的多线程分治实现
 */
public class BracketForkJoinPool {

    private int n;
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        result = new ArrayList<>();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new GenerateParenthesisTask("", 0, 0));

        return result;
    }

    private class GenerateParenthesisTask extends RecursiveAction {
        private String str;
        private int leftCount;
        private int rightCount;

        public GenerateParenthesisTask(String str, int leftCount, int rightCount) {
            this.str = str;
            this.leftCount = leftCount;
            this.rightCount = rightCount;
        }

        @Override
        protected void compute() {
            if (leftCount > n || rightCount > n || leftCount < rightCount) {
                return;
            }
            if (leftCount == n && rightCount == n) {
                result.add(str);
                return;
            }

            if (leftCount > rightCount) {
                GenerateParenthesisTask task1 = new GenerateParenthesisTask(str + "(", leftCount + 1, rightCount);
                GenerateParenthesisTask task2 = new GenerateParenthesisTask(str + ")", leftCount, rightCount + 1);
                invokeAll(task1, task2);
            }

            if (leftCount == rightCount) {
                GenerateParenthesisTask task = new GenerateParenthesisTask(str + "(", leftCount + 1, rightCount);
                task.fork();
                task.join();
            }
        }
    }
}