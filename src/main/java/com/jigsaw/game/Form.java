package com.jigsaw.game;

import javafx.scene.paint.Color;

public class Form {
    // First square.
    Piece a;
    // Second square.
    Piece b = null;
    // Third square.
    Piece c = null;
    // Fourth square.
    Piece d = null;
    // Fifth square.
    Piece e = null;

    // Constructor to create a figure consisting of one square.
    public Form(Piece a) {
        this.a = a;
    }

    // Constructor to create a figure consisting of two squares.
    public Form(Piece a, Piece b) {
        this.a = a;
        this.b = b;
    }
    // Constructor to create a figure consisting of three squares.
    public Form(Piece a, Piece b, Piece c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Constructor to create a figure consisting of four squares.
    public Form(Piece a, Piece b, Piece c, Piece d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // Constructor to create a shape consisting of five squares.
    public Form(Piece a, Piece b, Piece c, Piece d, Piece e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    /**
     * Method that checks each cell and if it exists, we paint over it.
     */
    public void setColorPiece() {
        if (a != null) {
            a.setColor(Color.DARKGOLDENROD);
        }
        if (b != null) {
            b.setColor(Color.DARKGOLDENROD);
        }
        if (c != null) {
            c.setColor(Color.DARKGOLDENROD);
        }
        if (d != null) {
            d.setColor(Color.DARKGOLDENROD);
        }
        if (e != null) {
            e.setColor(Color.DARKGOLDENROD);
        }
    }

    /**
     * Method that checks each cell and, if it exists, draws it.
     */
    public void drawPiece() {
        if (a != null) {
            a.draw();
        }
        if (b != null) {
            b.draw();
        }
        if (c != null) {
            c.draw();
        }
        if (d != null) {
            d.draw();
        }
        if (e != null) {
            e.draw();
        }
    }
}
