import org.example.AreaCalculator;
import org.example.MinutesToYearsDaysCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveMinutesToYearsDaysCalculatorTest {

    String expected, results;

    @Test
    public void testCalculateOne() {
        String[] expectedResults = {
            "525600 min = 1 y and 0 d",
            "1051200 min = 2 y and 0 d",
            "561600 min = 1 y and 25 d",
            "1049760 min = 1 y and 364 d",
        };
        long[] minutesForConversion = {
                525_600, 1_051_200, 561_600, 1_049_760
        };

        for (int i = 0; i < expectedResults.length; i++) {
            expected =  expectedResults[i];
            long minutes = minutesForConversion[i];
            results = MinutesToYearsDaysCalculator.printYearsAndDays(minutes);

            Assertions.assertEquals(expected, results);
        }
    }

    @Test
    public void testCalculateTwo() {
        expected = "Invalid Value";
        results =  MinutesToYearsDaysCalculator.printYearsAndDays(-5);

        Assertions.assertEquals(expected, results);
    }
}
