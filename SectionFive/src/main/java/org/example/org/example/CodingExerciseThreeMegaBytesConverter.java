package org.example;

public class CodingExerciseThreeMegaBytesConverter {

    public String printMegaBytesAndKiloBytes(int kiloBytes) {
        int megaBytes = 0;
        int remainingKiloBytes;
        int kiloBytesPerMegaByte = 1024;
        String result = "Invalid Value";

        if (kiloBytes >= 0) {
            megaBytes = kiloBytes / kiloBytesPerMegaByte;
            remainingKiloBytes = kiloBytes % kiloBytesPerMegaByte;
            result = STR."\{kiloBytes} KB = \{megaBytes} MB and \{remainingKiloBytes} KB";
        }

        return result;
    }
}
