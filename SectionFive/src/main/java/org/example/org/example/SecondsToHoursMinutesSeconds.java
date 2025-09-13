package org.example;

public class SecondsToHoursMinutesSeconds {
    public static int minutesToSeconds = 60;
    public static int hoursToMinutes = 60;

    public static String getDurationString(int totalSeconds) {
        if  (totalSeconds < 0) {return "Invalid input"; }
        int hours = (int) (totalSeconds / (hoursToMinutes * minutesToSeconds));

        // remainingSeconds will always be less than 3600 which is 1 hour
        int remainingSeconds = (int) (totalSeconds % (hoursToMinutes * minutesToSeconds));

        // remaining minutes will always be less than 60 which is 1 hour
        int minutes = (int) (remainingSeconds / minutesToSeconds);

        // remaining seconds will always be less than 60 which is 1 minute
        int seconds = (int) (remainingSeconds % minutesToSeconds);

        return STR."\{hours}h \{minutes}m \{seconds}s";
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || (seconds < 0 || seconds > 59)) {return "Invalid input";}
        int totalSeconds = minutes * minutesToSeconds + seconds;
        return getDurationString(totalSeconds);
    }
}
