package com.koou.file.serial;

import java.io.Serializable;

/**
 * Created by yunqiangdi on 3/8/2017.
 */
public class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    Animal(String name, House preferredHouse) {
        this.name = name;
        this.preferredHouse = preferredHouse;
    }

    @Override
    public String toString() {
        return name + "[" + super.toString() + "], "
                 + preferredHouse + "\n";
    }
}
