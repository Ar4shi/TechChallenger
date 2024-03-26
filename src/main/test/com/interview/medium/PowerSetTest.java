package com.interview.medium;

import org.junit.Test;

public class PowerSetTest {

    @Test
    public void testSubsets() {
        PowerSet powerSet = new PowerSet();
        int[] nums = {1, 2, 3};
        System.out.println(powerSet.subsets(nums));
    }
}
