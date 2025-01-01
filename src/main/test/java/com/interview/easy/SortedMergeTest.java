package java.com.interview.easy;

import com.interview.easy.SortedMerge;
import org.junit.Test;

public class SortedMergeTest {

    @Test
    public void test() {
        SortedMerge sortedMerge = new SortedMerge();
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        sortedMerge.merge(A, 3, B, 3);
        for (int i : A) {
            System.out.println(i);
        }
    }
}
