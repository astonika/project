package com.company.project.redission;


import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;

public class AtomicLongExamples {
    public static void main(String[] args) {
        // 默认连接上127.0.0.1:6379
        RedissonClient client = Redisson.create();
        RAtomicLong atomicLong = client.getAtomicLong("myLong");

        System.out.println("Init value: " + atomicLong.get());

        atomicLong.incrementAndGet();
        System.out.println("Current value: " + atomicLong.get());

        atomicLong.addAndGet(10L);
        System.out.println("Final value: " + atomicLong.get());

        client.shutdown();
    }
}
