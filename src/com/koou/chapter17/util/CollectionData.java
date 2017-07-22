package com.koou.chapter17.util;

import com.koou.common.interfaces.Generator;

import java.util.ArrayList;

/**
 * @author koou
 * @version 1.0
 * @since 2017-07-22 下午 19:44
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}
