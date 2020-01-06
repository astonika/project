package com.example.redislock;

import redis.clients.jedis.Jedis;

import static com.example.redislock.LockConstants.*;

public class LockCase2 extends RedisLock {

    public LockCase2(Jedis jedis, String name) {
        super(jedis, name);
    }

    @Override
    public void lock() {
        while (true) {
            String result = jedis.set(lockKey, "value", NOT_EXIST, SECONDS, 30);
            if (OK.equals(result)) {
                System.out.println(Thread.currentThread().getId() + "加锁成功!");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        jedis.del(lockKey);
    }
}
