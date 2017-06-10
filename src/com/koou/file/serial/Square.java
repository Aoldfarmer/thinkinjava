package com.koou.file.serial;

/**
 * Created by yunqiangdi on 3/8/2017.
 */
public class Square extends Shape {
    private static int color;

    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
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
