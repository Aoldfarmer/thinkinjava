package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/17/2017.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for ListOff!");
    }
}
