package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMegaBytesConverterThirdExercise {

    int[] kiloBytes = {2500, -1024, 5000, 1024, 0, 6023};
    String[] expectedMessages = {
            "2500 KB = 2 MB and 452 KB",
            "Invalid Value",
            "5000 KB = 4 MB and 904 KB",
            "1024 KB = 1 MB and 0 KB",
            "0 KB = 0 MB and 0 KB",
            "6023 KB = 5 MB and 903 KB"
    };

    @Test
    public void testMegaBytesConverterThirdExercise() {
        for (int index = 0; index < kiloBytes.length; index += 1) {
            int numberOfKiloBytes = kiloBytes[index];
            String expected = expectedMessages[index];
            String result = MegaBytesConverter.printMegaBytesAndKiloBytes(numberOfKiloBytes);
            assertEquals(expected, result);
        }
    }
}
