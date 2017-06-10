package com.koou.enums;

import com.koou.common.interfaces.Generator;

/**
 * Created by yunqiangdi on 3/15/2017.
 */
public class RandomInputGenerator implements Generator<Input> {

    public Input next() {
        return Input.randomSelection();
    }
}
