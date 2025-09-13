import org.example.SecondsToHoursMinutesSeconds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveTimeConversionTest {

    String expected, results;
    public static String errorMessage = "Invalid input";

    @Test
    public void testUnderOneMinute() {
        expected = "0h 0m 23s";
        results = SecondsToHoursMinutesSeconds.getDurationString(23);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testUnderOneHour() {
        expected = "0h 5m 30s";
        results = SecondsToHoursMinutesSeconds.getDurationString(330);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testUnderOneDay() {
        expected = "2h 17m 54s";
        results = SecondsToHoursMinutesSeconds.getDurationString(8274);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testUnderOneDaySecond() {
        expected = "13h 59m 5s";
        results =  SecondsToHoursMinutesSeconds.getDurationString(50345);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testInvalidInputForSeconds() {
        results = SecondsToHoursMinutesSeconds.getDurationString(-1);

        Assertions.assertEquals(errorMessage, results);
    }

    @Test
    public void testInvalidInputForMinutesAndSeconds() {
        int[] minutesInput =  {-1, 60, 23};
        int[] secondsInput = {50, 60, -1};

        for (int i = 0; i < minutesInput.length; i++) {
            int minutes = minutesInput[i];
            int seconds = secondsInput[i];
            String result = SecondsToHoursMinutesSeconds.getDurationString(minutes, seconds);
            Assertions.assertEquals(errorMessage, result);
        }
    }
}
