package com.example.concurrent.liaoxuefeng;

public class Main2MyThread {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程
    }
}
