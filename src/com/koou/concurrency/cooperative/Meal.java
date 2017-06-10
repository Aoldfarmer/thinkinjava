package com.koou.concurrency.cooperative;

/**
 * Created by yunqiangdi on 3/25/2017.
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}
