package java.basic.juc.threadlocal;

import basic.juc.threadlocal.UserAuthenticationService;
import org.junit.Test;

import static basic.juc.threadlocal.UserAuthenticationService.getCurrentUser;
import static basic.juc.threadlocal.UserAuthenticationService.loginUser;

public class UserAuthenticationServiceTest {

    @Test
    public void test() {
        // 模拟用户登录
        loginUser(new UserAuthenticationService.User("Alice", "password123"));
        System.out.println("User logged in: " + getCurrentUser().getUsername());

        // 模拟另一个线程处理另一个用户
        Runnable task = () -> {
            loginUser(new UserAuthenticationService.User("Bob", "password456"));
            System.out.println("User logged in: " + getCurrentUser().getUsername());
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
