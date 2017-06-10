package com.koou.concurrency.property;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class SynchronizingTest extends Incrementable {
    @Override
    public synchronized void increment() {
        ++counter;
    }
}
