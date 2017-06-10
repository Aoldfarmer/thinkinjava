package com.koou.concurrency.cons;

import com.koou.common.interfaces.Generator;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by yunqiangdi on 3/29/2017.
 */
public class ExchangerProducer<T> implements Runnable {

    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangerProducer(Generator<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++)
                    holder.add(generator.next());
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {

        }
    }
}
