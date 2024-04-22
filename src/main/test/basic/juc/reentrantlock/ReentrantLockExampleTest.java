package basic.juc.reentrantlock;

import org.junit.Test;

public class ReentrantLockExampleTest {

    @Test
    public void testAccessSharedResource() {
        ReentrantLockExample example = new ReentrantLockExample();

        // 创建两个线程，模拟并发访问
        Thread t1 = new Thread(example::accessSharedResource, "Thread-1");
        Thread t2 = new Thread(example::accessSharedResource, "Thread-2");

        t1.start();
        t2.start();
    }
}
