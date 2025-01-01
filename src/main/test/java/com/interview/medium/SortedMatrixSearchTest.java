package java.com.interview.medium;

import com.interview.medium.SortedMatrixSearch;
import org.junit.Test;

public class SortedMatrixSearchTest {

    @Test
    public void testSearchMatrix() {
        SortedMatrixSearch sortedMatrixSearch = new SortedMatrixSearch();
        int[][] matrix = {{}};
        int target = 1;
        System.out.println(sortedMatrixSearch.searchMatrix(matrix, target));
    }
}
