package com.example.concurrent;

public class MyThread extends Thread {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("OK!");
    }
}
