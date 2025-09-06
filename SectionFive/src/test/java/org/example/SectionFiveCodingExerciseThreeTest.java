import org.example.CodingExerciseThreeMegaBytesConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveCodingExerciseThreeTest {

    @Test
    public void testSectionFiveCodingExerciseThree() {
        int[] inputValue = new int[]{2500, -1024, 5000};
        String[] expected = new String[]{
                "2500 KB = 2 MB and 452 KB",
                "Invalid Value",
                "5000 KB = 4 MB and 904 KB"
        };
        CodingExerciseThreeMegaBytesConverter converter = new CodingExerciseThreeMegaBytesConverter();

        for (int index = 0; index < inputValue.length; index++) {
            Assertions.assertEquals(
                    expected[Math.toIntExact(index)],
                    converter.printMegaBytesAndKiloBytes(inputValue[Math.toIntExact(index)])
            );
        }

    }
}
