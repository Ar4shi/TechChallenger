package java.com.interview.medium;

import com.interview.medium.DrawLine;
import org.junit.Test;

import java.util.Arrays;

public class DrawLineTest {

    @Test
    public void testDrawLine() {
        DrawLine drawLine = new DrawLine();
        int[] ints = drawLine.drawLine(24, 96, 2, 19, 5);
        System.out.println(Arrays.toString(ints));
    }
}
