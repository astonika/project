package com.example.concurrent.liaoxuefeng;

public class Main6Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread6Interrupt();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}
