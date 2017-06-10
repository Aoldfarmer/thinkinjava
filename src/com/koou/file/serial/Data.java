package com.koou.file.serial;

import java.io.Serializable;

/**
 * Created by yunqiangdi on 3/7/2017.
 */
public class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
