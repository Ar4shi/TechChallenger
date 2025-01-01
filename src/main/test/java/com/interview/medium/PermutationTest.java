package java.com.interview.medium;

import com.interview.medium.Permutation;
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
