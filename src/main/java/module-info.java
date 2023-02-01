module com.jigsaw.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jigsaw.game to javafx.fxml;
    exports com.jigsaw.game;
}