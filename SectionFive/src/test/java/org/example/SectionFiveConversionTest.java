import org.example.ConversionChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveConversionTest {

    @Test
    public void testConvertToCentimetersFirstTest() {
        double expected = 2.54;
        double results = ConversionChallenge.convertToCentimeters(1);

        Assertions.assertEquals(expected, results, 0.01);
    }

    @Test
    public void testConvertToCentimetersSecondTest() {
        double expected = (12 * 2.54) + 2.54;
        double results = ConversionChallenge.convertToCentimeters(1, 1);

        Assertions.assertEquals(expected, results, 0.01);
    }

    @Test
    public void testConvertToCentimetersThirdTest() {
        double expected = 172.72;
        double results = ConversionChallenge.convertToCentimeters(5, 8);

        Assertions.assertEquals(expected, results, 0.01);
    }

}
