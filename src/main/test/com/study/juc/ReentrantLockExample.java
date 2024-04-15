package com.study.juc;

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

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        // 创建两个线程，模拟并发访问
        Thread t1 = new Thread(example::accessSharedResource, "Thread-1");
        Thread t2 = new Thread(example::accessSharedResource, "Thread-2");

        t1.start();
        t2.start();
    }
}
