package Tests;

import com.jigsaw.game.RandomGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckRandomGeneration {
    /**
     * Check that the generation occurs in the correct range
     * from minimum to maximum also included.
     */
    @Test
    public void checkRandom() {
        RandomGeneration randomGeneration = new RandomGeneration();
        int number = randomGeneration.generateFromTo(0, 12);
        int check = number >= 0 && number <= 12 ? 1 : 0;
        Assertions.assertEquals(check, 1);
    }
}
