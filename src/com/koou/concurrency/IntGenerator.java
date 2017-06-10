package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/22/2017.
 */
public abstract class IntGenerator {
    private volatile boolean cancelled = false;
    public abstract int next();
    public void cancel() {
        cancelled = true;
    }
    public boolean isCancelled() {
        return cancelled;
    }
}
