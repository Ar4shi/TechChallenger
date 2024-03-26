package com.interview.easy;

import org.junit.Test;

public class ThreeStepsProblemTest {

    @Test
    public void testWaysToStep() {
        ThreeStepsProblem threeStepsProblem = new ThreeStepsProblem();
        int result = threeStepsProblem.waysToStep(61);
        System.out.println(result);
    }
}
