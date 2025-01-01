package java.com.interview.medium;

import com.interview.medium.Bracket;
import org.junit.Test;

import java.util.List;

public class BracketTest {

    @Test
    public void testBracket() {
        Bracket bracket = new Bracket();
        List<String> list = bracket.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
