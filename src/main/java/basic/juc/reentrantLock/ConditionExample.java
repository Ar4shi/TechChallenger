package basic.juc.reentrantLock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    public class BoundedBuffer<T> {
        private final LinkedList<T> buffer;  // 使用 LinkedList 作为缓冲区
        private final int capacity;          // 缓冲区最大容量
        private final ReentrantLock lock;    // 互斥锁
        private final Condition notEmpty;    // 缓冲区非空条件
        private final Condition notFull;     // 缓冲区非满条件

        public BoundedBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer = new LinkedList<>();
            this.lock = new ReentrantLock();
            this.notEmpty = lock.newCondition();
            this.notFull = lock.newCondition();
        }

        // 放入一个元素
        public void put(T item) throws InterruptedException {
            lock.lock();
            try {
                // 如果缓冲区满，等待
                while (buffer.size() == capacity) {
                    notFull.await();
                }
                buffer.add(item);
                System.out.println(" Put item : " + item + " buffer size : " + buffer.size());
                // 通知可能正在等待的消费者
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        // 取出一个元素
        public T take() throws InterruptedException {
            lock.lock();
            try {
                // 如果缓冲区空，等待
                while (buffer.isEmpty()) {
                    notEmpty.await();
                }
                T item = buffer.removeFirst();
                System.out.println(" Take item : " + item + " buffer size : " + buffer.size());
                // 通知可能正在等待的生产者
                notFull.signal();
                return item;
            } finally {
                lock.unlock();
            }
        }
    }
}
