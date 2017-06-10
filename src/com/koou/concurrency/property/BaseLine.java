package com.koou.concurrency.property;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class BaseLine extends Accumulator {
    {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
        value += preLoaded[index++];
        if(index >= SIZE) index = 0;
    }

    @Override
    public long read() {
        return value;
    }
}
