package com.koou.concurrency.property;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class SynchronizedTest extends Accumulator {
    {
        id = "synchronized";
    }

    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) index = 0;
    }

    @Override
    public long read() {
        return value;
    }
}
