package com.koou.concurrency.cooperative;

/**
 * Created by yunqiangdi on 3/25/2017.
 */
public class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {

        }
    }
    synchronized void prod() {
        notify();
    }
    synchronized void prodAll() {
        notifyAll();
    }
}
