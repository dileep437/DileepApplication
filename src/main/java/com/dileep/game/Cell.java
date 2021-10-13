package com.dileep.game;

import java.util.StringJoiner;

/**
 * 
 * @author 7504686
 *
 */
public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cell.class.getSimpleName() + "[", "]").add("x=" + x).add("y=" + y).toString();
    }
}
