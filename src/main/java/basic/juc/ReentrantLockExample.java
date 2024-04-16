package basic.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void accessSharedResource() {
        lock.lock();  // 获取锁
        try {
            // 访问或修改共享资源
            System.out.println("Resource accessed by: " + Thread.currentThread().getName());
        } finally {
            lock.unlock();  // 无论如何都要释放锁
        }
    }
}
