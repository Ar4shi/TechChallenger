package com.interview.medium;

import org.junit.Test;

public class PermutationTest {

    @Test
    public void testPermutation() {
        Permutation permutation = new Permutation();
        String[] result = permutation.permutation("qwe");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
