package org.example;

public class SecondsToHoursMinutesSeconds {
    public static int minutesToSeconds = 60;
    public static int hoursToMinutes = 60;

    public static String getDurationString(int totalSeconds) {
        if  (totalSeconds < 0) {return "Invalid input"; }
        int hours = (int) (totalSeconds / (hoursToMinutes * minutesToSeconds));
        int remainingSeconds = (int) (totalSeconds % (hoursToMinutes * minutesToSeconds));
        int minutes = (int) (remainingSeconds / minutesToSeconds);
        int seconds = (int) (remainingSeconds % minutesToSeconds);

        return STR."\{hours}h \{minutes}m \{seconds}s";
    }

    public static String getDurationString(int minutes, int seconds) {
        if (seconds < 0 || (minutes < 0 || minutes > 59)) {return "Invalid input";}
        int totalSeconds = minutes * minutesToSeconds + seconds;
        return getDurationString(totalSeconds);
    }
}
