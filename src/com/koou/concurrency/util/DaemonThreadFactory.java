package com.koou.concurrency.util;

import java.util.concurrent.ThreadFactory;

/**
 * Created by yunqiangdi on 3/21/2017.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
