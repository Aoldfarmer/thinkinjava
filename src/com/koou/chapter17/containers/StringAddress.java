package com.koou.chapter17.containers;

/**
 * @author koou
 * @version 1.0
 * @since 2017-07-22 下午 19:19
 */
public class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
