package com.koou.concurrency.cons;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yunqiangdi on 3/27/2017.
 */
public class CountDownLatchDemo {
    static final int SIZE = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for (int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        System.out.println("Launched all tasks");
        exec.shutdown();
    }
}
