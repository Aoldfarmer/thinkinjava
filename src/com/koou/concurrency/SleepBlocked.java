package com.koou.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by yunqiangdi on 3/24/2017.
 */
public class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
