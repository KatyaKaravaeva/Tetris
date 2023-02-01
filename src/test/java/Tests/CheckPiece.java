package Tests;

import com.jigsaw.game.Piece;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckPiece {
    /**
     * Check that the get and set methods work correctly.
     */
    @Test
    public void checkSetAndGetCoords() {
        Piece piece = new Piece(1, 1, new Rectangle());
        piece.setX(2);
        piece.setY(3);
        Assertions.assertEquals(piece.getX(), 2);
        Assertions.assertEquals(piece.getY(), 3);
    }


}
