package com.jigsaw.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Piece {
    // Coordinate x.
    private double x;
    // Coordinate y.
    private double y;
    // Fixed initial coordinates that were set during generation.
    public double genX;
    public double genY;
    // The object of the square, which will be part of the generated figure.
    private final Rectangle rectangle;

    // Constructor that initializes the coordinates and the square, part of the future figure.
    public Piece(double x, double y, Rectangle rectangle) {
        this.x = x;
        this.y = y;
        genX = x;
        genY = y;
        this.rectangle = rectangle;
    }

    /**
     * Method that sets the y coordinate to the value passed in the parameters.
     *
     * @param y coordinate y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Method that sets the x coordinate to the value passed in the parameters.
     *
     * @param x coordinate x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Method that gets the value of the y-coordinate.
     *
     * @return y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Method that gets the value of the x-coordinate.
     *
     * @return x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Method that sets a rectangle to a color.
     *
     * @param color color
     */
    public void setColor(Color color) {
        rectangle.setFill(color);
    }

    /**
     * Method that draws a rectangle.
     */
    public void draw() {
        rectangle.setHeight(40);
        rectangle.setWidth(40);
        rectangle.setTranslateX(x);
        rectangle.setTranslateY(y);
    }
}

