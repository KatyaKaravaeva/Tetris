package Tests;

import com.jigsaw.game.Timer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckTimer {

    /**
     * Check that the default timer has zeroed values.
     */
    @Test
    public void checkTimerDefault() {
        Timer timer = new Timer();
        Assertions.assertEquals(timer.showTime(), "0:0:0");
    }

    /**
     * Check that the time addition method works correctly.
     */
    @Test
    public void checkTimerPlusSeconds() {
        Timer timer = new Timer();
        for (int i = 0; i < 61; i++) {
            timer.setPlusOne();
        }
        Assertions.assertEquals(timer.showTime(), "0:1:1");
    }

}
