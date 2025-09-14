import org.example.IntEqualityPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveTestIntEqualityPrinter {

    String expected, results;

    @Test
    public void testForInvalidValue() {
        int[][] inputValues = new int[][]{{1, 1, 1}, {1, 1, 2}, {-1, -1, -1} ,{1, 2, 3}};
        String[] expectedReturns = new String[]{
                "All numbers are equal",
                "Neither all are equal or different",
                "Invalid Value",
                "All numbers are different"
        };

        for (int i = 0; i < inputValues.length; i++) {
            expected = expectedReturns[i];
            int[] input =  inputValues[i];
            int first = input[0]; int second =  input[1]; int third = input[2];
            results = IntEqualityPrinter.printEqual(first, second, third);

            Assertions.assertEquals(expected, results);
        }
    }
}
