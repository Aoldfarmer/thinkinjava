package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/23/2017.
 */
public class PairMainpulator implements Runnable {
    private PairManager pm;

    public PairMainpulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true)
            pm.increment();
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}
