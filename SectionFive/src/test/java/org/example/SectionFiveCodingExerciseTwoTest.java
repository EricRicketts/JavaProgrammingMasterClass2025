import org.example.CodingExerciseTwoSpeedConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SectionFiveCodingExerciseTwoTest {

    public static CodingExerciseTwoSpeedConverter codingExerciseTwoSpeedConverter;

    @BeforeAll
    public static void setup() {
        codingExerciseTwoSpeedConverter = new CodingExerciseTwoSpeedConverter();
    }

    @Test
    public void testKilometersToMilesPerHour () {
        long[] expected = new long[]{1, 6, -1, 16, 47};
        double[] inputValues = new double[]{1.5, 10.25, -5.6, 25.42, 75.114};

        for (int index = 0; index < inputValues.length; index++) {
            long result = codingExerciseTwoSpeedConverter.toMilesPerHour(inputValues[index]);
            Assertions.assertEquals(expected[index], result);
        }
    }

    @Test
    public void testPrintConversion() {
        double[] inputValues = new double[]{1.5, 10.25, -5.6, 25.42, 75.114};
        String[] expected =  new String[]{
                "1.5 km/h = 1 mi/h",
                "10.25 km/h = 6 mi/h",
                "Invalid Value",
                "25.42 km/h = 16 mi/h",
                "75.114 km/h = 47 mi/h"
        };

        for (int index = 0; index < inputValues.length; index++ ) {
            Assertions.assertEquals(
                    expected[index],
                    codingExerciseTwoSpeedConverter.printConversion(inputValues[index]));
        }
    }
}
