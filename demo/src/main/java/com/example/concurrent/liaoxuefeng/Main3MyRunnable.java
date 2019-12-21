package com.example.concurrent.liaoxuefeng;

public class Main3MyRunnable {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
    }
}
