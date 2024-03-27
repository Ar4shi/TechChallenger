package com.interview.medium;

import org.junit.Test;

import java.util.List;

public class BracketTest {

    @Test
    public void testBracket() {
        Bracket bracket = new Bracket();
        List<String> list = bracket.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
