package java.com.interview.medium;

import com.interview.medium.PowerSet;
import org.junit.Test;

public class PowerSetTest {

    @Test
    public void testSubsets() {
        PowerSet powerSet = new PowerSet();
        int[] nums = {1, 2, 3};
        System.out.println(powerSet.subsets(nums));
    }
}
