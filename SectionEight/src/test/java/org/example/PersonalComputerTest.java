package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalComputerTest {

    private PersonalComputer personalComputer;
    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;
    private static final String MODEL = "Pro Max";
    private static final String MANUFACTURER = "Dell";
    private static final int WIDTH = 200;
    private static final int HEIGHT = 75;
    private static final int DEPTH = 150;
    private static final int SIZE = 34;
    private static final String RESOLUTION = "3440x1440";;
    private static final int RAM_SLOTS = 4;
    private static final int CARD_SLOTS = 6;
    private static final String BIOS = "UEFI";
    private static final String POWER_SUPPLY = "500W";

    @BeforeEach
    public void setUp() {
        monitor = new Monitor(
            MODEL,
            MANUFACTURER,
            WIDTH,
            HEIGHT,
            DEPTH,
            SIZE,
            RESOLUTION
        );

        motherboard = new Motherboard(
            MODEL,
            MANUFACTURER,
            WIDTH,
            HEIGHT,
            DEPTH,
            RAM_SLOTS,
            CARD_SLOTS,
            BIOS
        );

        computerCase = new ComputerCase(
            MODEL,
            MANUFACTURER,
            WIDTH,
            HEIGHT,
            DEPTH,
            POWER_SUPPLY
        );

        personalComputer = new PersonalComputer(
            MODEL,
            MANUFACTURER,
            WIDTH,
            HEIGHT,
            DEPTH,
            monitor,
            motherboard,
            computerCase
        );
    }

    @Nested
    @DisplayName("test personal computer monitor")
    class TestPersonalComputerMonitor {

        @Test
        public void testPersonalComputerMonitorGetModel() {
            assertEquals(
                MODEL,
                personalComputer.getMonitor().getModel()
            );
        }

        @Test
        public void testPersonalComputerMonitorGetManufacturer() {
            assertEquals(
                MANUFACTURER,
                personalComputer.getMonitor().getManufacturer()
            );
        }

        @Test
        public void testPersonalComputerMonitorGetWidth() {
            assertEquals(
                WIDTH,
                personalComputer.getMonitor().getWidth()
            );
        }

        @Test
        public void testPersonalComputerMonitorGetHeight() {
            assertEquals(
                HEIGHT,
                personalComputer.getMonitor().getHeight()
            );
        }

        @Test
        public void testPersonalComputerMonitorGetDepth() {
            assertEquals(
                DEPTH,
                personalComputer.getMonitor().getDepth()
            );
        }

        @Test
        public void testPersonalComputerMonitorGetSize() {
            assertEquals(
                SIZE,
                personalComputer.getMonitor().getSize()
            );
        }

        @Test
        public void testPersonalComputerMonitorGetResolution() {
            assertEquals(
                RESOLUTION,
                personalComputer.getMonitor().getResolution()
            );
        }
    }
}
