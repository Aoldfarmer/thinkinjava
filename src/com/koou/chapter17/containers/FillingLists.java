package com.koou.chapter17.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author koou
 * @version 1.0
 * @since 2017-07-22 下午 19:26
 */
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello"))
        );
        System.out.println(list);
        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
