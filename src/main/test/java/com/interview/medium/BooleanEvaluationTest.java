package java.com.interview.medium;

import com.interview.medium.BooleanEvaluation;
import org.junit.Test;

public class BooleanEvaluationTest {

    @Test
    public void test() {
        BooleanEvaluation booleanEvaluation = new BooleanEvaluation();
        int result = booleanEvaluation.countEval("0&0&0&1^1|0", 1);
        System.out.println(result);
    }
}
