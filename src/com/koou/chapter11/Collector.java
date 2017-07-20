package com.koou.chapter11;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-07-20 10:23 AM
 */
public interface Collector<T> extends UnaryFunction<T, T> {

    T result();
}
