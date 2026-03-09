package org.example;

public class MegaBytesConverter {

    public static String printMegaBytesAndKiloBytes(int kiloBytes) {
        String message = "Invalid Value";
        int kiloBytesPerMegaByte = 1024;
        int megaBytes = kiloBytes / kiloBytesPerMegaByte;
        int remainingKiloBytes = kiloBytes % kiloBytesPerMegaByte;
        if (kiloBytes >= 0) {
            message = kiloBytes + " KB = " + megaBytes + " MB and "
                    + remainingKiloBytes + " KB";
        }
        return message;
    }
}
