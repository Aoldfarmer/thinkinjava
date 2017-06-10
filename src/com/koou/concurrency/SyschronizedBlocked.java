package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/24/2017.
 */
public class SyschronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true)
            Thread.yield();
    }

    public SyschronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
