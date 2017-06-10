package com.koou.concurrency.cons;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yunqiangdi on 3/27/2017.
 */
public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException ex) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d " , id);
    }
}
