package com.jigsaw.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinishController implements Initializable {
    @FXML
    private Label info;
    @FXML
    private Label winText;
    @FXML
    private AnchorPane anchorPaneMain;

    int points;
    String time;
    Stage stage;
    int figures;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info.setText("You win");
        winText.setText("Congratulations! If you click on the exit button,\n you will find your results");
    }

    /**
     * An alert that once again clarifies to the user that he definitely
     * wants to close the application and notifies him of the results of the game.
     *
     * @param event event
     */
    @FXML
    void exitFinish(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText(" For the game you earned " + points + " points and " + figures + " figures \n " +
                "The time it took you to play the game was " + time);
        alert.setContentText("Do you really want to finish the game?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) anchorPaneMain.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * Method that gets the value of the time that the player played and initializes the time field.
     *
     * @param time time that the player played
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Method that gets the value of the squares transferred to the field
     * by the user and initializes that value.
     *
     * @param points value of the squares amount
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Method that gets the value of the shapes transferred to the field by the user
     * and initializes that value.
     *
     * @param figures value of the shapes amount
     */
    public void setFigures(int figures) {
        this.figures = figures;
    }

    /**
     * Method that is tied to a button to start a new game.
     *
     * @param event event
     */
    @FXML
    void startNewGame(ActionEvent event) {
        stage = (Stage) anchorPaneMain.getScene().getWindow();
        stage.close();
        HelloApplication helloApplication = new HelloApplication();
        try {
            helloApplication.start(stage);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error . Try again!");
            alert.showAndWait();
        }
    }
}
