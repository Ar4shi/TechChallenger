package basic.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelCalculation {

    public static final int N_THREADS = 4;
    public static final ExecutorService exec = Executors.newFixedThreadPool(N_THREADS);
}
