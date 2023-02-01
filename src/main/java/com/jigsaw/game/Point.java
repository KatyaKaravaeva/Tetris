package com.jigsaw.game;

public class Point {
    // Coordinate x.
    public int x;
    public int y;

    // Set the value of coordinates in the constructor with a shift on the generation field.
    public Point(int x, int y) {
        this.x = x + 9;
        this.y = y + 3;
    }
}
