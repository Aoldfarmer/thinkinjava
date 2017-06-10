package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/22/2017.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught " + e);
    }
}
