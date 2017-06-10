package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/17/2017.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
