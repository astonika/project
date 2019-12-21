package com.example.concurrent.liaoxuefeng;

public class MyThread7Interrupt extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("HelloThread interrupted!");
        }
        hello.interrupt();
    }
}
