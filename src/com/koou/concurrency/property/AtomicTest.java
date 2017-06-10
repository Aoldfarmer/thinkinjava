package com.koou.concurrency.property;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class AtomicTest extends Accumulator {
    {
        id = "Atomic";
    }
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    @Override
    public void accumulate() {
        int i = index.getAndIncrement();
        if (++i >= SIZE)
            index.set(0);
        value.getAndAdd(preLoaded[index.get()]);
    }

    @Override
    public long read() {
        return value.get();
    }
}
