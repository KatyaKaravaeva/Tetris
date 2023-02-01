package com.jigsaw.game;

public class RandomGeneration {

    // An array of coordinates that help generate various shapes.
    Point[][] coords = {{new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(0, 2)},
            {new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2)},
            {new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2)},
            {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1)},
            {new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(2, 2)},
            {new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(0, 2)},
            {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2)},
            {new Point(0, 1), new Point(0, 0), new Point(1, 0), new Point(2, 0)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
            {new Point(0, 2), new Point(1, 2), new Point(1, 1), new Point(2, 1)},
            {new Point(2, 0), new Point(2, 1), new Point(1, 1), new Point(1, 2)},
            {new Point(0, 1), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
            {new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(0, 2)},
            {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2)},
            {new Point(0, 2), new Point(0, 1), new Point(0, 0), new Point(1, 0), new Point(2, 0)},
            {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(2, 2)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)},
            {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(1, 1)},
            {new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1)},
            {new Point(1, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2)},
            {new Point(1, 0), new Point(1, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2)},
            {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)},
            {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 1), new Point(2, 1)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0), new Point(2, 2)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2)},
            {new Point(1, 1)},
            {new Point(0, 0), new Point(1, 0), new Point(0, 1)},
            {new Point(1, 0), new Point(2, 0), new Point(2, 1)},
            {new Point(0, 1), new Point(0, 2), new Point(1, 2)},
            {new Point(2, 1), new Point(2, 2), new Point(1, 2)}
    };
    // A random number that selects an array of points in a two-dimensional array of coords.
    int numberInCoords;
    // An array that will hold randomly chosen points that form the shape.
    Point[] figure;
    // The coordinates of the five points that can form a figure.
    // If the figure consists of less than five squares, such fields are filled with -1.
    int firstX;
    int firstY;
    int secondX;
    int secondY;
    int thirdX;
    int thirdY;
    int forthX;
    int forthY;
    int fifthX;
    int fifthY;
    // Number of rectangles, or rather squares, which will consist of a figure.
    int numberOfRec;
    // A flag that verifies that a piece has been used,
    // this is needed in order to prohibit the movement of the piece on the field in the future.
    Boolean wasUse;

    public RandomGeneration() {
        // Select an array of points in a two-dimensional array, for this we generate a number.
        numberInCoords = generateFromTo(0, coords.length - 1);
        // From the generated number we put the information about the points in the array.
        figure = coords[numberInCoords];
        // Initialize the default number of blocks in the shape,
        // flag that it was not used, and set the default value to coordinates.
        numberOfRec = figure.length;
        wasUse = false;
        firstX = -1;
        firstY = -1;
        secondX = -1;
        secondY = -1;
        thirdX = -1;
        thirdY = -1;
        forthX = -1;
        forthY = -1;
        // Select the method of filling.
        fill();
    }

    /**
     * Method that sets the value of the flag true,
     * which means that this object has already been used.
     */
    public void used() {
        wasUse = true;
    }

    /**
     * Method of filling coordinates at points in the figure array.
     * Filling occurs depending on how many squares the figure contains.
     */
    private void fill() {
        if (figure.length == 1) {
            setFirstX(figure[0].x);
            setFirstY(figure[0].y);
        } else if (figure.length == 2) {
            setFirstX(figure[0].x);
            setFirstY(figure[0].y);
            setSecondX(figure[1].x);
            setSecondY(figure[1].y);
        } else if (figure.length == 3) {
            setFirstX(figure[0].x);
            setFirstY(figure[0].y);
            setSecondX(figure[1].x);
            setSecondY(figure[1].y);
            setThirdX(figure[2].x);
            setThirdY(figure[2].y);
        } else if (figure.length == 4) {
            setFirstX(figure[0].x);
            setFirstY(figure[0].y);
            setSecondX(figure[1].x);
            setSecondY(figure[1].y);
            setThirdX(figure[2].x);
            setThirdY(figure[2].y);
            setForthX(figure[3].x);
            setForthY(figure[3].y);
        } else {
            setFirstX(figure[0].x);
            setFirstY(figure[0].y);
            setSecondX(figure[1].x);
            setSecondY(figure[1].y);
            setThirdX(figure[2].x);
            setThirdY(figure[2].y);
            setForthX(figure[3].x);
            setForthY(figure[3].y);
            setFifthX(figure[4].x);
            setFifthY(figure[4].y);
        }
    }

    /**
     * Random number generation method.
     * The minimum possible value of the generation result,
     * as well as the maximum is given in the input.
     *
     * @param min minimum possible generation value.
     * @param max maximum possible generation value.
     * @return result of generation
     */
    public int generateFromTo(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }

    // Methods for all five coordinates that allow to set values to coordinates as well as to get them.
    public int getFirstX() {
        return firstX;
    }

    public void setFirstX(int firstX) {
        this.firstX = firstX;
    }

    public int getFirstY() {
        return firstY;
    }

    public void setFirstY(int firstY) {
        this.firstY = firstY;
    }

    public int getSecondX() {
        return secondX;
    }

    public void setSecondX(int secondX) {
        this.secondX = secondX;
    }

    public int getSecondY() {
        return secondY;
    }

    public void setSecondY(int secondY) {
        this.secondY = secondY;
    }

    public int getThirdX() {
        return thirdX;
    }

    public void setThirdX(int thirdX) {
        this.thirdX = thirdX;
    }

    public int getThirdY() {
        return thirdY;
    }

    public void setThirdY(int thirdY) {
        this.thirdY = thirdY;
    }

    public int getForthX() {
        return forthX;
    }

    public void setForthX(int forthX) {
        this.forthX = forthX;
    }

    public int getForthY() {
        return forthY;
    }

    public void setForthY(int forthY) {
        this.forthY = forthY;
    }

    public int getFifthX() {
        return fifthX;
    }

    public void setFifthX(int fifthX) {
        this.fifthX = fifthX;
    }

    public int getFifthY() {
        return fifthY;
    }

    public void setFifthY(int fifthY) {
        this.fifthY = fifthY;
    }
}
