package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/23/2017.
 */
public class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
