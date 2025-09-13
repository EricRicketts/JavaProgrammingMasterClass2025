import org.example.AreaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaCalculatorTest {

    double expected, results;

    @Test
    public void testCalculateAreaOne() {
        expected = 78.53981;
        results = AreaCalculator.area(5.0);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testCalculateAreaTwo() {
        expected = 20.0;
        results = AreaCalculator.area(5.0, 4.0);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testCalculateAreaThree() {
        expected = -1.0;
        results = AreaCalculator.area(-1.0);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testCalculateAreaFour() {
        expected = -1.0;
        results = AreaCalculator.area(-1.0, 4.0);

        Assertions.assertEquals(expected, results);
    }
}
