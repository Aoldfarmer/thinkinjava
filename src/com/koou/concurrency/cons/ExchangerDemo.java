package com.koou.concurrency.cons;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;
    public static void main(String[] args) throws Exception {
        if (args.length > 0)
            size = new Integer(args[0]);
        if (args.length > 1)
            delay = new Integer(args[1]);
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>(),
                  consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(BasicGenerator.create(Fat.class), xc,  producerList));
        exec.execute(new ExchangerConsumer<>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
