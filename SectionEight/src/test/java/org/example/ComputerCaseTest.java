package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerCaseTest {

    private ComputerCase computerCase;
    private static final String MODEL = "Pro Tower Desktop";
    private static final String MANUFACTURER = "Dell";
    private static final String POWER_SUPPLY = "500W";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 20;
    private static final int DEPTH = 40;

    @BeforeEach
    public void setUp() {
        computerCase = new ComputerCase(
            MODEL,
            MANUFACTURER,
            WIDTH,
            HEIGHT,
            DEPTH,
            POWER_SUPPLY
        );
    }

    @Nested
    @DisplayName("test computer case getters")
    class TestComputerCaseGetters {

        @Test
        public void testComputerCaseGetModel() {
            assertEquals(MODEL, computerCase.getModel());
        }

        @Test
        public void testComputerCaseGetManufacturer() {
            assertEquals(MANUFACTURER, computerCase.getManufacturer());
        }

        @Test
        public void testComputerCaseGetWidth() {
            assertEquals(WIDTH, computerCase.getWidth());
        }

        @Test
        public void testComputerCaseGetHeight() {
            assertEquals(HEIGHT, computerCase.getHeight());
        }

        @Test
        public void testComputerCaseGetDepth() {
            assertEquals(DEPTH, computerCase.getDepth());
        }

        @Test
        public void testComputerCaseGetPowerSupply() {
            assertEquals(POWER_SUPPLY, computerCase.getPowerSupply());
        }
    }

    @Nested
    @DisplayName("test computer case press power button")
    class TestComputerCasePressPowerButton {

        @Test
        public void testComputerCasePressPowerButton() {
            String expected = "Power button pressed.";
            String actual = computerCase.pressPowerButton();

            assertEquals(expected, actual);
        }
    }
}
