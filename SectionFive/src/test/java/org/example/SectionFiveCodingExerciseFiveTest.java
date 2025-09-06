import org.example.CodingExerciseFiveIsLeapYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveCodingExerciseFiveTest {

    @Test
    public void sectionFiveCodingExerciseFiveTest() {
        int[] years = new int[]{
                1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600,
                1600, 2000, 2004, 2024, 2048, 2400
        };
        boolean[] expected = new  boolean[]{
                false, false, false, false, false, false,
                false, false, true, true, true, true, true, true
        };
        CodingExerciseFiveIsLeapYear test = new CodingExerciseFiveIsLeapYear();
        for (int i = 0; i < years.length; i++) {
            Assertions.assertEquals(expected[i], test.isLeapYear(years[i]));
        }
    }
}
