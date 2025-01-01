package java.com.interview.easy;

import com.interview.easy.Exchange;
import org.junit.Test;

public class ExchangeTest {

    @Test
    public void testExchangeBits() {
        Exchange exchange = new Exchange();
        int result = exchange.exchangeBits(3);
        System.out.println(result);
    }
}
