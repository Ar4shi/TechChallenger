package java.com.leetcode.solution01_100.solution41_50;

import com.leetcode.Solution01_100.Solution41_50.TrappingRainWater_42;
import org.junit.Test;

public class TrappingRainWaterTest_42 {

    @Test
    public void test() {
        TrappingRainWater_42 trappingRainWater = new TrappingRainWater_42();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWater.trap(height));
    }
}
