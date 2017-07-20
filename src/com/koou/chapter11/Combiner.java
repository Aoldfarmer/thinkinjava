package com.koou.chapter11;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-07-20 10:12 AM
 */
public interface Combiner<T> {
    T combine(T x, T y);
}
