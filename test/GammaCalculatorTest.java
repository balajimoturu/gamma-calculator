import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GammaCalculatorTest {

    @Test
    void testGammaOfFive() {
        assertEquals(24.0, GammaCalculatorApp.gamma(5), 0.01);
    }

    @Test
    void testGammaOfHalf() {
        assertEquals(Math.sqrt(Math.PI), GammaCalculatorApp.gamma(0.5), 0.01);
    }

    @Test
    void testGammaInvalidZero() {
        assertThrows(IllegalArgumentException.class, () -> GammaCalculatorApp.gamma(0));
    }
}
