package com.interview.medium;

import org.junit.Test;

import java.util.List;

public class BracketForkJoinPoolTest {

    @Test
    public void test() {
        BracketForkJoinPool bracketForkJoinPool = new BracketForkJoinPool();
        List<String> list = bracketForkJoinPool.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
