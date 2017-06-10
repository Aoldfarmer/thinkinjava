package com.koou.concurrency.cons;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by yunqiangdi on 3/28/2017.
 */
public class PriortizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PriortizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run();
        } catch (InterruptedException e) {

        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
