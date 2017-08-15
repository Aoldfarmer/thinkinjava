package com.koou.concurrency.practice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-08-15 10:37 AM
 */
public class BoundedBufferTest {

    @Test
    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertTrue(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for (int i = 0; i < 10; i++)
            bb.put(i);
        assertTrue(bb.isFull());
        assertTrue(bb.isEmpty());
    }

    @Test
    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread() {
            @Override
            public void run() {
                try {
                    int unused = bb.take();
                    fail();
                } catch (InterruptedException success) {

                }
            }
        };

        try {
            taker.start();
            Thread.sleep(10000);
            taker.interrupt();
            taker.join(10000);
            assertFalse(taker.isAlive());
        } catch (Exception e) {
            fail();
        }
    }

}