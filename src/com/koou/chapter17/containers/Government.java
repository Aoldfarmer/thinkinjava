package com.koou.chapter17.containers;

import com.koou.common.interfaces.Generator;

/**
 * @author koou
 * @version 1.0
 * @since 2017-07-22 下午 19:51
 */
public class Government implements Generator<String> {

    String[] foundation = ("strange women lying in ponds " + "distributing swords is no" +
            " basis for a system of government").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
