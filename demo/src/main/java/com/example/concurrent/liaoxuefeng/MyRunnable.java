package com.example.concurrent.liaoxuefeng;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}
