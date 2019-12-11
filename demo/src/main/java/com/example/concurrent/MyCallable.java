package com.example.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable extends OtherClass implements Callable<Integer> {

    private static final int nThreads = 2;
    private int id;

    public MyCallable() {

    }

    public MyCallable(int id) {
        this.id = id;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        thread.start();
        System.out.println("返回值是:" + future.get());
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
