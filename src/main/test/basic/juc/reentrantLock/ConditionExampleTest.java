package basic.juc.reentrantLock;

import org.junit.Test;

import java.util.Random;

public class ConditionExampleTest {

    @Test
    public void testCondition() throws InterruptedException {
        ConditionExample example = new ConditionExample();
        ConditionExample.BoundedBuffer<Integer> buffer = example.new BoundedBuffer<>(5);
        Random random = new Random();

        // 创建两个线程，模拟并发访问
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    buffer.put(i);
                    Thread.sleep(random.nextInt(1001));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-1");
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    buffer.take();
                    Thread.sleep(random.nextInt(1001));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Test finished");
    }
}
