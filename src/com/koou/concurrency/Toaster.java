package com.koou.concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunqiangdi on 3/27/2017.
 */
public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand =  new Random(47);
    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
