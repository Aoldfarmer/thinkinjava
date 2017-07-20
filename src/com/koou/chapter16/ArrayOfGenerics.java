package com.koou.chapter16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-07-20 5:07 PM
 */
public class ArrayOfGenerics {

    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = la;
        ls[0] = new ArrayList<>();

//        ls[1] = new ArrayList<>(Integer);

        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

    }

}
