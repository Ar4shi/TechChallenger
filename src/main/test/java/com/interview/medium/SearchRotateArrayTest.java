package java.com.interview.medium;

import com.interview.medium.SearchRotateArray;
import org.junit.Test;

public class SearchRotateArrayTest {

    @Test
    public void testSearch() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] arr = {1, 1, 1, 1, 1, 2, 1, 1, 1};
        int target = 2;
        System.out.println(searchRotateArray.search(arr, target));
    }

    @Test
    public void testSearch2() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;
        System.out.println(searchRotateArray.search(arr, target));
    }

    @Test
    public void testSearch3() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] arr = {5, 5, 5, 1, 2, 3, 4, 5};
        int target = 5;
        System.out.println(searchRotateArray.search(arr, target));
    }

    @Test
    public void testSearch4() {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] arr = {2, 1, 2, 2, 2};
        int target = 2;
        System.out.println(searchRotateArray.search(arr, target));
    }
}
