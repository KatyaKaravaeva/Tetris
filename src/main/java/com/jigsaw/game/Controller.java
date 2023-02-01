package com.jigsaw.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // Label, which displays the value of the timer.
    @FXML
    private Label timer;
    @FXML
    private Pane pane;
    // The object of the timer class, which is responsible for the time that the user played.
    static Timer time;
    // The size of the playing field.
    static private final int SIZE = 360;
    // The number of columns at the playing field.
    static private final int COLOMS = 9;
    // The number of cells at the playing field.
    static private final int PARTS = SIZE / COLOMS;
    // private ArrayList<Form> forms;
    // A two-dimensional array that mimics the playing field.
    static private Rectangle[][] grid;
    // The object of the RandomGeneration class.
    RandomGeneration random;
    // The object of the Field class.
    private static Field field;
    // Every second the time is updated (increases by one second)
    // and the value in the label is updated.
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), x -> {
        time.setPlusOne();
        timer.setText(time.showTime());
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        newDraw();
        makeRect();
        field = new Field(COLOMS, COLOMS);
        time = new Timer();
    }

    /**
     * Method that causes a new form to be created (after the game ends).
     *
     * @param event pressing the button - end the game
     */
    @FXML
    public void helpMethod(ActionEvent event) {
        createFinishForm();
    }

    /**
     * This method closes the current form and opens a new form in which
     * the player can either exit the game or start a new one.
     */
    private void createFinishForm() {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("finish-game.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 400);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error. Try again!");
            alert.showAndWait();
            return;
        }
        Stage createWindow = new Stage();
        createWindow.setScene(scene);
        createWindow.setTitle("Win");
        createWindow.initModality(Modality.APPLICATION_MODAL);
        FinishController controller = fxmlLoader.getController();
        // Transfers to another controller the time the player spent on the game.
        controller.setTime(time.showTime());
        // Тransmits to another controller the number of squares
        // that the player dragged onto the field.
        controller.setPoints(field.getPoints());
        // Transmits to another controller the number of pieces
        // that the player dragged onto the field.
        controller.setFigures(field.getCountFigurePoints());
        createWindow.showAndWait();
    }

    /**
     * Change the color of the squares, when you click on the figure.
     *
     * @param event clicking on a shape
     * @param form  current figure
     */
    public static void pressed(MouseEvent event, Form form) {
        form.setColorPiece();
    }

    /**
     * Simulating the movement of a figure.
     *
     * @param event  moving a figure across the field.
     * @param form   current figure
     * @param random the object of the RandomGeneration class
     */
    public static void dragged(MouseEvent event, Form form, RandomGeneration random) {
        // Check that the object has not been used before, that is,
        // the user has not dragged a piece onto the field.
        if (!random.wasUse) {
            // Set the new coordinates and draw a square.
            form.a.setX(form.a.getX() + event.getX());
            form.a.setY(form.a.getY() + event.getY());
            form.a.draw();
            // Check that such a square exists.
            if (form.b != null) {
                // Set the new coordinates and draw a square.
                form.b.setX(form.b.getX() + event.getX());
                form.b.setY(form.b.getY() + event.getY());
                form.b.draw();
            }
            // Check that such a square exists.
            if (form.c != null) {
                // Set the new coordinates and draw a square.
                form.c.setX(form.c.getX() + event.getX());
                form.c.setY(form.c.getY() + event.getY());
                form.c.draw();
            }
            // Check that such a square exists.
            if (form.d != null) {
                // Set the new coordinates and draw a square.
                form.d.setX(form.d.getX() + event.getX());
                form.d.setY(form.d.getY() + event.getY());
                form.d.draw();
            }
            // Check that such a square exists.
            if (form.e != null) {
                // Set the new coordinates and draw a square.
                form.e.setX(form.e.getX() + event.getX());
                form.e.setY(form.e.getY() + event.getY());
                form.e.draw();
            }
        }
    }

    /**
     * Method to check that the square is inside the field.
     *
     * @param field square, which is part of the figure
     * @return 0 if the square is inside the field, otherwise - 1
     */
    public static int checkPositionField(Piece field) {
        if ((field.getX() >= 0 && field.getX() <= 360 && field.getY() >= 0 && field.getY() <= 360)) {
            return 0;
        }
        return 1;
    }


    /**
     * Method that checks if a figure is out of bounds (9 by 9)
     *
     * @param gridxA x coordinate of the "A" square on the grid
     * @param gridyA y coordinate of the "A" square on the grid
     * @param gridxB x coordinate of the "B" square on the grid
     * @param gridyB y coordinate of the "B" square on the grid
     * @param gridxC x coordinate of the "C" square on the grid
     * @param gridyC y coordinate of the "C" square on the grid
     * @param gridxD x coordinate of the "D" square on the grid
     * @param gridyD y coordinate of the "D" square on the grid
     * @param gridxE x coordinate of the "E" square on the grid
     * @param gridyE y coordinate of the "E" square on the grid
     * @return True, if the figure is out of the boundaries of the field, otherwise false
     */
    public static Boolean checkBounds(int gridxA, int gridyA, int gridxB,
                                      int gridyB, int gridxC, int gridyC,
                                      int gridxD, int gridyD, int gridxE, int gridyE) {
        return gridxA > 9 || gridyA > 9 || gridxB > 9
                || gridyB > 9 || gridxC > 9 || gridyC > 9
                || gridxD > 9 || gridyD > 9 || gridxE > 9 || gridyE > 9;
    }

    /**
     * Method of checking that these cells have already been occupied by a player
     * and a piece cannot be placed here.
     *
     * @param form   current figure
     * @param gridxA x coordinate of the "A" square on the grid
     * @param gridyA y coordinate of the "A" square on the grid
     * @param gridxB x coordinate of the "B" square on the grid
     * @param gridyB y coordinate of the "B" square on the grid
     * @param gridxC x coordinate of the "C" square on the grid
     * @param gridyC y coordinate of the "C" square on the grid
     * @param gridxD x coordinate of the "D" square on the grid
     * @param gridyD y coordinate of the "D" square on the grid
     * @param gridxE x coordinate of the "E" square on the grid
     * @param gridyE y coordinate of the "E" square on the grid
     * @return true if the place was already occupied by another figure, otherwise false
     */
    public static Boolean checkBusy(Form form, int gridxA, int gridyA, int gridxB,
                                    int gridyB, int gridxC, int gridyC,
                                    int gridxD, int gridyD, int gridxE, int gridyE) {
        Boolean check = false;
        if (gridxA > -1 && gridyA > -1 && gridxB < 9 && gridyB < 9 && checkPositionField(form.a) == 0) {
            check = field.field[gridyA][gridxA] == 0 ? check : true;
        }
        if (gridxB > -1 && gridyB > -1 && gridxB < 9 && gridyB < 9 && checkPositionField(form.b) == 0) {
            check = field.field[gridyB][gridxB] == 0 ? check : true;
        }
        if (gridxC > -1 && gridyC > -1 && gridxC < 9 && gridyC < 9 && checkPositionField(form.c) == 0) {
            check = field.field[gridyC][gridxC] == 0 ? check : true;
        }
        if (gridxD > -1 && gridyD > -1 && gridxD < 9 && gridyD < 9 && checkPositionField(form.d) == 0) {
            check = field.field[gridyD][gridxD] == 0 ? check : true;
        }
        if (gridxE > -1 && gridyE > -1 && gridxE < 9 && gridyE < 9 && checkPositionField(form.e) == 0) {
            check = field.field[gridyE][gridxE] == 0 ? check : true;
        }
        return check;
    }

    public static void released(MouseEvent event, Form p, RandomGeneration random) {
        // Check that no square in the figure does not go beyond the boundaries
        // of the grid, if any square will go out, the counter value will be increased by one.
        int check = 0;
        check += (p.a != null) ? checkPositionField(p.a) : 0;
        check += (p.b != null) ? checkPositionField(p.b) : 0;
        check += (p.c != null) ? checkPositionField(p.c) : 0;
        check += (p.d != null) ? checkPositionField(p.d) : 0;
        check += (p.e != null) ? checkPositionField(p.e) : 0;
        int gridxA = -1, gridyA = -1, gridxB = -1, gridyB = -1;
        int gridxC = -1, gridyC = -1, gridxD = -1, gridyD = -1, gridxE = -1, gridyE = -1;
        if (p.a != null) {
            gridxA = (int) p.a.getX() / (PARTS);
            gridyA = (int) p.a.getY() / (PARTS);
        }
        if (p.b != null) {
            gridxB = (int) p.b.getX() / (PARTS);
            gridyB = (int) p.b.getY() / (PARTS);
        }
        if (p.c != null) {
            gridxC = (int) p.c.getX() / (PARTS);
            gridyC = (int) p.c.getY() / (PARTS);
        }
        if (p.d != null) {
            gridxD = (int) p.d.getX() / (PARTS);
            gridyD = (int) p.d.getY() / (PARTS);
        }
        if (p.e != null) {
            gridxE = (int) p.e.getX() / (PARTS);
            gridyE = (int) p.e.getY() / (PARTS);
        }
        // Check that on the field where a piece is to be placed
        // there is already another piece that was placed earlier.
        Boolean busuFlag = checkBusy(p, gridxA, gridyA, gridxB, gridyB, gridxC, gridyC,
                gridxD, gridyD, gridxE, gridyE);
        // Check that the figure is within the 9x9 boundaries.
        Boolean checkInd = checkBounds(gridxA, gridyA, gridxB, gridyB, gridxC, gridyC,
                gridxD, gridyD, gridxE, gridyE);
        // If any conditions are met, we return the figure to the place of generation.
        if ((check > 0 || checkInd || busuFlag) && !random.wasUse) {
            p.a.setX(p.a.genX);
            p.a.setY(p.a.genY);
        } else {
            grid[gridxA][gridyA].setFill(Color.CRIMSON);
            field.setPointOnField(gridyA, gridxA);
            p.a.setX((PARTS) * gridxA);
            p.a.setY((PARTS) * gridyA);
        }
        if (p.b != null) {
            // If any conditions are met, we return the figure to the place of generation.
            if ((check > 0 || checkInd || busuFlag) && !random.wasUse) {
                p.b.setX(p.b.genX);
                p.b.setY(p.b.genY);
            } else {
                grid[gridxB][gridyB].setFill(Color.CRIMSON);
                field.setPointOnField(gridyB, gridxB);
                p.b.setX((PARTS) * gridxB);
                p.b.setY((PARTS) * gridyB);
            }
        }
        if (p.c != null) {
            // If any conditions are met, we return the figure to the place of generation.
            if ((check > 0 || checkInd || busuFlag) && !random.wasUse) {
                p.c.setX(p.c.genX);
                p.c.setY(p.c.genY);
            } else {
                grid[gridxC][gridyC].setFill(Color.CRIMSON);
                field.setPointOnField(gridyC, gridxC);
                p.c.setX((PARTS) * gridxC);
                p.c.setY((PARTS) * gridyC);
            }
        }
        if (p.d != null) {
            // If any conditions are met, we return the figure to the place of generation.
            if ((check > 0 || checkInd || busuFlag) && !random.wasUse) {
                p.d.setX(p.d.genX);
                p.d.setY(p.d.genY);
            } else {
                grid[gridxD][gridyD].setFill(Color.CRIMSON);
                field.setPointOnField(gridyD, gridxD);
                p.d.setX((PARTS) * gridxD);
                p.d.setY((PARTS) * gridyD);
            }
        }
        if (p.e != null) {
            // If any conditions are met, we return the figure to the place of generation.
            if ((check > 0 || checkInd || busuFlag) && !random.wasUse) {
                p.e.setX(p.e.genX);
                p.e.setY(p.e.genY);
            } else {
                grid[gridxE][gridyE].setFill(Color.CRIMSON);
                field.setPointOnField(gridyE, gridxE);
                p.e.setX((PARTS) * gridxE);
                p.e.setY((PARTS) * gridyE);
            }
        }
        if ((check > 0 || checkInd || busuFlag)) {
            p.drawPiece();
        } else {
            p.drawPiece();
            if (!random.wasUse) {
                field.setCountFigurePoints();
            }
            random.used();
        }
    }

    /**
     * Drawing the grid.
     */
    public void newDraw() {
        int generateColoms = 3;
        grid = new Rectangle[COLOMS + generateColoms][COLOMS];
        int generateSize = 120;
        for (int i = 0; i < SIZE + generateSize; i += PARTS) {
            for (int j = 0; j < SIZE; j += PARTS) {
                if (i >= SIZE && j < 40 * 3 || i >= SIZE && j >= 40 * 6) {
                    continue;
                }
                if (i < SIZE) {
                    Rectangle r = new Rectangle(i, j, PARTS, PARTS);
                    grid[i / PARTS][j / PARTS] = r;
                    r.setFill(Color.WHITE);
                    r.setStroke(Color.BLACK);
                    pane.getChildren().add(r);
                } else {
                    Rectangle r = new Rectangle(i, j, PARTS, PARTS);
                    grid[i / PARTS][j / PARTS] = r;
                    r.setFill(Color.LIGHTCORAL);
                    r.setStroke(Color.BLACK);
                    pane.getChildren().add(r);
                }
            }
        }
    }

    /**
     * Generating a new figure
     *
     * @param event clicking on the figure generation button
     */
    @FXML
    void generateNewFigure(ActionEvent event) {
        makeRect();
    }

    /**
     * The method of creating a new figure,
     * which in turn consists of a specific number of squares.
     */
    public void makeRect() {
        // Cell size.
        int move = 40;
        random = new RandomGeneration();
        Rectangle first, second = null, third = null, forth = null, fifth = null;
        Piece firstPiece, secondPiece = null, thirdPiece = null, forthPiece = null, fifthPiece = null;
        // Creating a figure if it consists of a single square.
        if (random.numberOfRec == 1) {
            first = new Rectangle();
            first.setFill(Color.GREEN);
            first.setStroke(Color.BLACK);
            firstPiece = new Piece(random.getFirstX() * move, random.getFirstY() * move, first);
            firstPiece.draw();
        } else if (random.numberOfRec == 2) {
            // Creating a figure if it consists of two square.
            first = new Rectangle();
            first.setFill(Color.GREEN);
            first.setStroke(Color.BLACK);
            firstPiece = new Piece(random.getFirstX() * move, random.getFirstY() * move, first);
            firstPiece.draw();

            second = new Rectangle();
            second.setFill(Color.GREEN);
            second.setStroke(Color.BLACK);
            secondPiece = new Piece(random.getSecondX() * move, random.getSecondY() * move, second);
            secondPiece.draw();
        } else if (random.numberOfRec == 3) {
            // Creating a figure if it consists of three square.
            first = new Rectangle();
            first.setFill(Color.GREEN);
            first.setStroke(Color.BLACK);
            firstPiece = new Piece(random.getFirstX() * move, random.getFirstY() * move, first);
            firstPiece.draw();

            second = new Rectangle();
            second.setFill(Color.GREEN);
            second.setStroke(Color.BLACK);
            secondPiece = new Piece(random.getSecondX() * move, random.getSecondY() * move, second);
            secondPiece.draw();

            third = new Rectangle();
            third.setFill(Color.GREEN);
            third.setStroke(Color.BLACK);
            thirdPiece = new Piece(random.getThirdX() * move, random.getThirdY() * move, third);
            thirdPiece.draw();
        } else if (random.numberOfRec == 4) {
            // Creating a figure if it consists of four square.
            first = new Rectangle();
            first.setFill(Color.GREEN);
            first.setStroke(Color.BLACK);
            firstPiece = new Piece(random.getFirstX() * move, random.getFirstY() * move, first);
            firstPiece.draw();

            second = new Rectangle();
            second.setFill(Color.GREEN);
            second.setStroke(Color.BLACK);
            secondPiece = new Piece(random.getSecondX() * move, random.getSecondY() * move, second);
            secondPiece.draw();

            third = new Rectangle();
            third.setFill(Color.GREEN);
            third.setStroke(Color.BLACK);
            thirdPiece = new Piece(random.getThirdX() * move, random.getThirdY() * move, third);
            thirdPiece.draw();

            forth = new Rectangle();
            forth.setFill(Color.GREEN);
            forth.setStroke(Color.BLACK);
            forthPiece = new Piece(random.getForthX() * move, random.getForthY() * move, forth);
            forthPiece.draw();
        } else {
            // Creating a figure if it consists of five square.
            first = new Rectangle();
            first.setFill(Color.GREEN);
            first.setStroke(Color.BLACK);
            firstPiece = new Piece(random.getFirstX() * move, random.getFirstY() * move, first);
            firstPiece.draw();

            second = new Rectangle();
            second.setFill(Color.GREEN);
            second.setStroke(Color.BLACK);
            secondPiece = new Piece(random.getSecondX() * move, random.getSecondY() * move, second);
            secondPiece.draw();

            third = new Rectangle();
            third.setFill(Color.GREEN);
            third.setStroke(Color.BLACK);
            thirdPiece = new Piece(random.getThirdX() * move, random.getThirdY() * move, third);
            thirdPiece.draw();

            forth = new Rectangle();
            forth.setFill(Color.GREEN);
            forth.setStroke(Color.BLACK);
            forthPiece = new Piece(random.getForthX() * move, random.getForthY() * move, forth);
            forthPiece.draw();

            fifth = new Rectangle();
            fifth.setFill(Color.GREEN);
            fifth.setStroke(Color.BLACK);
            fifthPiece = new Piece(random.getFifthX() * move, random.getFifthY() * move, fifth);
            fifthPiece.draw();
        }
        // Ceate a new shape depending on the number of squares in the shape
        // and bind it to the pane.
        Form newForm;
        if (random.numberOfRec == 1) {
            newForm = new Form(firstPiece);
            pane.getChildren().addAll(first);
        } else if (random.numberOfRec == 2) {
            newForm = new Form(firstPiece, secondPiece);
            pane.getChildren().addAll(first, second);
        } else if (random.numberOfRec == 3) {
            newForm = new Form(firstPiece, secondPiece, thirdPiece);
            pane.getChildren().addAll(first, second, third);
        } else if (random.numberOfRec == 4) {
            newForm = new Form(firstPiece, secondPiece, thirdPiece, forthPiece);
            pane.getChildren().addAll(first, second, third, forth);
        } else {
            newForm = new Form(firstPiece, secondPiece, thirdPiece, forthPiece, fifthPiece);
            pane.getChildren().addAll(first, second, third, forth, fifth);
        }
        // Linking the figure to events.
        first.setOnMousePressed(event -> pressed(event, newForm));
        first.setOnMouseDragged(event -> dragged(event, newForm, random));
        first.setOnMouseReleased(event -> released(event, newForm, random));
        // Check that the square exists.
        if (second != null) {
            // Linking the figure to events.
            second.setOnMousePressed(event -> pressed(event, newForm));
            second.setOnMouseDragged(event -> dragged(event, newForm, random));
            second.setOnMouseReleased(event -> released(event, newForm, random));
        }
        // Check that the square exists.
        if (third != null) {
            // Linking the figure to events.
            third.setOnMousePressed(event -> pressed(event, newForm));
            third.setOnMouseDragged(event -> dragged(event, newForm, random));
            third.setOnMouseReleased(event -> released(event, newForm, random));
        }
        // Check that the square exists.
        if (forth != null) {
            // Linking the figure to events.
            forth.setOnMousePressed(event -> pressed(event, newForm));
            forth.setOnMouseDragged(event -> dragged(event, newForm, random));
            forth.setOnMouseReleased(event -> released(event, newForm, random));
        }
        // Check that the square exists.
        if (fifth != null) {
            // Linking the figure to events.
            fifth.setOnMousePressed(event -> pressed(event, newForm));
            fifth.setOnMouseDragged(event -> dragged(event, newForm, random));
            fifth.setOnMouseReleased(event -> released(event, newForm, random));
        }
    }
}