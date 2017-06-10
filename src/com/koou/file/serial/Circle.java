package com.koou.file.serial;

/**
 * Created by yunqiangdi on 3/8/2017.
 */
public class Circle extends Shape {
    private static int color = RED;

    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}
