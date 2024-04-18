package basic.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportExample {

    private Thread t1, t2, t3;

    public Thread getT1() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                LockSupport.park();
                System.out.print("A");
                LockSupport.unpark(t2);
            }
        });
        return t1;
    }

    public Thread getT2() {
        t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                LockSupport.park();
                System.out.print("B");
                LockSupport.unpark(t3);
            }
        });
        return t2;
    }

    public Thread getT3() {
        t3 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                LockSupport.park();
                System.out.print("C");
                LockSupport.unpark(t1);
            }
        });
        return t3;
    }

}
