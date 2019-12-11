package com.example.concurrent;

public class MyRunnable extends OtherClass implements Runnable {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("OK!");
    }
}
