package com.koou.concurrency;

/**
 * Created by yunqiangdi on 3/23/2017.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public synchronized static int nextSerialNumber() {
        return serialNumber++;
    }
}
