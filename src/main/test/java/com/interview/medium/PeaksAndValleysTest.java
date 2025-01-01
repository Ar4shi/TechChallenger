package java.com.interview.medium;

import com.interview.medium.PeaksAndValleys;
import org.junit.Test;

public class PeaksAndValleysTest {

    @Test
    public void testWiggleSort() {
        PeaksAndValleys peaksAndValleys = new PeaksAndValleys();
        int[] nums = {3, 5, 2, 1, 6, 4};
        peaksAndValleys.wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
