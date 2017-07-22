package com.koou.chapter17.containers;

import com.koou.chapter17.util.CollectionData;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author koou
 * @version 1.0
 * @since 2017-07-22 下午 19:54
 */
public class CollectionDataTest {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
