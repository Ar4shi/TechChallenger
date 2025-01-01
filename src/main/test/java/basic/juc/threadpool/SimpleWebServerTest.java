package java.basic.juc.threadpool;

import basic.juc.threadpool.SimpleWebServer;
import org.junit.Test;

public class SimpleWebServerTest {

    @Test
    public void test() {
        while (true) {
            // 接收请求
            Runnable request = new Runnable() {
                public void run() {
                    // 处理请求
                    System.out.println("Request handled by " + Thread.currentThread().getName());
                }
            };

            SimpleWebServer.exec.execute(request);
        }
    }
}
