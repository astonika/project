package com.example.concurrent.liaoxuefeng;

public class Main7Interrupt {
    public static void main(String[] args) {
        Thread t = new MyThread7Interrupt();
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("MyThread7Interrupt0 interrupted!");
        }
        t.interrupt(); // 中断t线程
        try {
           t.join(); // 等待t线程结束
        } catch (InterruptedException e){
            System.out.println("MyThread7Interrupt interrupted!");
        }
        System.out.println("end");
    }
}
