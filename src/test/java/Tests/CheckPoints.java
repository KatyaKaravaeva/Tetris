package Tests;

import com.jigsaw.game.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckPoints {
    /**
     * Check that when coordinates are specified in the constructor,
     * there is a shift. By x coordinate by 9, by y coordinate by 3.
     */
    @Test
    public void checkPointsShift() {
        Point point = new Point(0, 0);
        Assertions.assertEquals(point.x, 9);
        Assertions.assertEquals(point.y, 3);
    }

}
