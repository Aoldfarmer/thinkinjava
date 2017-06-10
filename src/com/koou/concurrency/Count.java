package com.koou.concurrency;

import java.util.Random;

/**
 * Created by yunqiangdi on 3/23/2017.
 */
public class Count {
    private int count = 0;
    private Random rand = new Random(47);
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value() {
        return count;
    }
}
