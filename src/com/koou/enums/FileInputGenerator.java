package com.koou.enums;

import com.koou.common.interfaces.Generator;
import com.koou.common.utils.TextFile;

import java.util.Iterator;

/**
 * Created by yunqiangdi on 3/15/2017.
 */
public class FileInputGenerator implements Generator<Input>  {

    private Iterator<String> input;
    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }
    public Input next() {
        if(!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
