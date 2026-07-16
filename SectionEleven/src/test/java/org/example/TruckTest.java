package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckTest {

    private Truck truck;

    @BeforeEach
    public void setUp() {
        truck = new Truck();
    }

    @Nested
    @DisplayName("test truck track method")
    class TestTruckTrackMethod {

        @Test
        public void testTruckTrackMethod() {
            assertEquals(
                "Truck coordinates recorded.",
                truck.track()
            );
        }
    }
}
