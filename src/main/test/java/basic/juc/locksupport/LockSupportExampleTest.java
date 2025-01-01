package java.basic.juc.locksupport;

import basic.juc.locksupport.LockSupportExample;
import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportExampleTest {

    @Test
    public void testLockSupport() {
        LockSupportExample example = new LockSupportExample();
        Thread t1 = example.getT1();
        Thread t2 = example.getT2();
        Thread t3 = example.getT3();

        t1.start();
        t2.start();
        t3.start();

        LockSupport.unpark(t1);
    }
}
