package com.jigsaw.game;

public class Field {
    // Field width.
    int width;
    // Field height.
    int height;
    int[][] field;
    // Сounter that shows how many pieces have been added by a player to the field.
    int countFigurePoints;
    // Сounter that shows how many cells a player has added to the field.
    int busyPoints;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new int[width][height];
        busyPoints = 0;
    }


    /**
     * This method reads information that a new square has been added to the field
     * and adds that information to a two-dimensional array.
     * This method also has a counter that shows how many squares the user has added during the game.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void setPointOnField(int x, int y) {
        if (x >= 9 || y >= 9) {
            return;
        }
        this.field[x][y] = 1;
        ++busyPoints;
    }

    /**
     * This method checks whether the field was completely filled with the shapes that the user placed.
     *
     * @return true if completely filled in, otherwise false
     */
    public Boolean checkGameFinish() {
        return busyPoints == 81;
    }

    /**
     * Method that adds one to the counter that
     * is responsible for the number of shapes the user has added.
     */
    public void setCountFigurePoints() {
        ++countFigurePoints;
    }

    /**
     * Method that returns a counter that is responsible for the number of shapes the user has added.
     *
     * @return counter that is responsible for the number of shapes
     */
    public int getCountFigurePoints() {
        return countFigurePoints;
    }

    /**
     * Method that returns a counter that is responsible for the number of squares on the field
     * that the user added.
     *
     * @return counter that is responsible for the number of squares on the field
     */
    public int getPoints() {
        return busyPoints;
    }
}
