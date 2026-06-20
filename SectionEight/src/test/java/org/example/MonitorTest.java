package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonitorTest {

    private Monitor monitor;

    private static final String MODEL = "ViewFinity";
    private static final String MANUFACTURER = "Samsung";
    private static final int WIDTH = 32;
    private static final int HEIGHT = 18;
    private static final int DEPTH = 9;
    private static final int SIZE = 34;
    private static final String RESOLUTION = "3440x1440";

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
    }

    @Nested
    @DisplayName("test monitor getters")
    class TestMonitorGetters {

        @Test
        public void testMonitorGetModel() {
            assertEquals(MODEL, monitor.getModel());
        }

        @Test
        public void testMonitorGetManufacturer() {
            assertEquals(MANUFACTURER, monitor.getManufacturer());
        }

        @Test
        public void testMonitorGetWidth() {
            assertEquals(WIDTH, monitor.getWidth());
        }

        @Test
        public void testMonitorGetHeight() {
            assertEquals(HEIGHT, monitor.getHeight());
        }

        @Test
        public void testMonitorGetDepth() {
            assertEquals(DEPTH, monitor.getDepth());
        }

        @Test
        public void testMonitorGetSize() {
            assertEquals(SIZE, monitor.getSize());
        }

        @Test
        public void testMonitorGetResolution() {
            assertEquals(RESOLUTION, monitor.getResolution());
        }
    }

    @Nested
    @DisplayName("test monitor draw pixel")
    class TestMonitorDrawPixel {

        @Test
        public void testMonitorDrawlPixel() {
            String expected = "Drawing pixel at 100, 50 in color blue.";
            String result = monitor.drawPixelAt(100, 50, "blue");

            assertEquals(expected, result);
        }
    }
}
