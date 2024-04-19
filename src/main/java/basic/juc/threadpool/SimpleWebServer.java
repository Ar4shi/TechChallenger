package basic.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleWebServer {

    public static final int N_THREADS = 100;
    public static final ExecutorService exec = Executors.newFixedThreadPool(N_THREADS);

}
