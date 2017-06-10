package com.koou.concurrency.property;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
abstract class Incrementable {
    protected long counter = 0;
    public abstract void increment();
}
