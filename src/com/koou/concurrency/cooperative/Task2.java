package com.koou.concurrency.cooperative;

/**
 * Created by yunqiangdi on 3/25/2017.
 */
public class Task2 implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
