package basic.juc.concurrenthashmap;

import org.junit.Test;

public class ConcurrentHashMapExampleTest {

    @Test
    public void testConcurrentHashMap() {
        ConcurrentHashMapExample example = new ConcurrentHashMapExample();
        example.userVisited("user1");
        example.userVisited("user1");
        example.userVisited("user2");

        System.out.println("User1 visit count: " + example.getVisitCount("user1"));
        System.out.println("User2 visit count: " + example.getVisitCount("user2"));
    }
}
