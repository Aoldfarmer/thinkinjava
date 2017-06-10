package com.koou.concurrency.property;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class LockingTest extends Incrementable {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}
