package com.koou.chapter16;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-07-20 5:39 PM
 */
public class ArrayOfGenericType<T> {

    T[] array;

    public ArrayOfGenericType(int size) {
        array = (T[]) new Object[size];
    }
}
