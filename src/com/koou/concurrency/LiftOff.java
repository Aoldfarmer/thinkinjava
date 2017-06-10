package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/17/2017.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Listoff!") +
                "), ";
    }

    @Override
    public void run() {
        while (countDown-- >0) {
            System.out.println(status());
            Thread.yield();
        }
    }


}
