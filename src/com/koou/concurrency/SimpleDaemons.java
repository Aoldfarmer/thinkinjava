package com.koou.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by yunqiangdi on 3/21/2017.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDaemons());
            deamon.setDaemon(true);
            deamon.start();
        }

        System.out.println("All deamons started");
        TimeUnit.MILLISECONDS.sleep(10000);
    }
}
