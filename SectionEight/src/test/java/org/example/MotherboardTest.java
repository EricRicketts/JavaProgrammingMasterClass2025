package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotherboardTest {

    private Motherboard motherboard;
    private static final String MODEL = "Intel Z890";
    private static final String MANUFACTURER = "Msi";
    private static final int WIDTH = 30;
    private static final int HEIGHT = 15;
    private static final int DEPTH = 20;
    private static final int RAM_SLOTS = 4;
    private static final int CARD_SLOTS = 6;
    private static final String BIOS = "UEFI";

    @BeforeEach
    public void setUp() {
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
    }

    @Nested
    @DisplayName("test motherboard getters")
    class TestMotherBoardGetters {

        @Test
        public void testMotherboardGetModel() {
            assertEquals(MODEL, motherboard.getModel());
        }

        @Test
        public void testMotherboardGetManufacturer() {
            assertEquals(MANUFACTURER, motherboard.getManufacturer());
        }

        @Test
        public void testMotherboardGetWidth() {
            assertEquals(WIDTH, motherboard.getWidth());
        }

        @Test
        public void testMotherboardGetHeight() {
            assertEquals(HEIGHT, motherboard.getHeight());
        }

        @Test
        public void testMotherboardGetDepth() {
            assertEquals(DEPTH, motherboard.getDepth());
        }

        @Test
        public void testMotherboardGetRamSlots() {
            assertEquals(RAM_SLOTS, motherboard.getRamSlots());
        }

        @Test
        public void testMonitorGetCardSlots() {
            assertEquals(CARD_SLOTS, motherboard.getCardSlots());
        }

        @Test
        public void testMonitorGetBois() {
            assertEquals(BIOS, motherboard.getBios());
        }
    }

    @Nested
    @DisplayName("test motherboard load program")
    class TestMotherBoardLoadProgram {

        @Test
        public void testMotherboardLoadProgram() {
            String expected = "Loading Program Linux Operating System.";
            String actual = motherboard.loadProgram("Linux Operating System");

            assertEquals(expected, actual);
        }
    }
}
