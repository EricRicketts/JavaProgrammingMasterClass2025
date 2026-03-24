package org.example;

import org.example.ComputerCase;
import org.example.Motherboard;
import org.example.PersonalComputer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalComputerTest {

    PersonalComputer pc;
    String expected, result;

    @BeforeEach
    public void setUp() {
        ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
        Monitor theMonitor = new Monitor(
                "27in Beast",
                "Acer",
                27,
                "2540 x 1440");
        Motherboard theMotherboard = new Motherboard(
                "BJ-200",
                "Asus",
                4,
                6,
                "V2.44");
        pc = new PersonalComputer("2208", "Dell", theMonitor, theMotherboard, theCase);
    }

    @Test
    public void testTellMonitorToDrawAPixel() {
        expected = "Drawing pixel at 5, 10 in color red.";
        result = pc.getMonitor().drawPixelAt(5, 10, "red");
        assertEquals(expected, result);
    }

    @Test
    public void testMotherboardIsLoadingAProgram() {
        expected = "Program Windows OS is now loading...";
        result = pc.getMotherboard().loadProgram("Windows OS");
        assertEquals(expected, result);
    }

    @Test
    public void testComputerCasePowerButton() {
        expected = "Power button pressed.";
        result = pc.getComputerCase().pressPowerButton();
        assertEquals(expected, result);
    }
}
