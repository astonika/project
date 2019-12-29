package com.example.concurrent.liaoxuefeng;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizeBasedTaskQueue {

    private Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notify();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

}
