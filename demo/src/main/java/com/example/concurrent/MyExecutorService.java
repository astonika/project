package com.example.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService extends OtherClass implements Callable<Integer> {

    private static final int nThreads = 2;
    private int id;

    public MyExecutorService() {

    }

    public MyExecutorService(int id) {
        this.id = id;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            Callable<Integer> callable = new MyExecutorService(i);
            Future<Integer> future = executorService.submit(callable);
            list.add(future);
        }
        executorService.shutdown();

        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }
    }

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 10; i++) {
            //当前线程
            System.out.println("当前线程是：" + Thread.currentThread() + ":" + i);
        }
        return i;
    }
}
