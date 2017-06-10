package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/23/2017.
 */
public class PairManager1 extends PairManager {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
