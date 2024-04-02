package com.interview.hard;

import org.junit.Test;

public class EightQueensTest {

    @Test
    public void testSolveNQueens() {
        EightQueens eightQueens = new EightQueens();
        System.out.println(eightQueens.solveNQueens(10));
    }
}
