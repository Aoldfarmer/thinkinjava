package com.koou.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by yunqiangdi on 3/24/2017.
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.out.print("usage: java interruptingIdiom delay-in-ms");
//            System.exit(1);
//        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t.interrupt();
    }
}
