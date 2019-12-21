package com.example.concurrent.liaoxuefeng;

public class MyThread6Interrupt extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}
