package java.com.interview.hard;

import com.interview.hard.PileBox;
import org.junit.Test;

public class PileBoxTest {

    @Test
    public void test() {
        PileBox pileBox = new PileBox();
        int[][] boxes = {{1, 1, 1}, {2, 3, 4}, {2, 6, 7},{3, 4, 5}};
        int result = pileBox.pileBox(boxes);
        System.out.println(result);
    }
}
