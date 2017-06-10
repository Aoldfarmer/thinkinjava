package com.koou.concurrency.cons;

import java.util.concurrent.DelayQueue;

/**
 * Created by yunqiangdi on 3/28/2017.
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                q.take().run();
        } catch (InterruptedException e) {

        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
