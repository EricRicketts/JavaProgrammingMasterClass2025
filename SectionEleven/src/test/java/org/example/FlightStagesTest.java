package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightStagesTest {

    private FlightStages flightStages;


    @Nested
    @DisplayName("test track method of flight stages")
    class TestFlightStagesTrackMethod {

        @Test
        public void testNotGrounded() {
            flightStages = FlightStages.LAUNCH;
            assertEquals(
                "Monitoring FlightStages",
                flightStages.track()
            );
        }

        @Test
        public void testGrounded() {
            flightStages = FlightStages.GROUNDED;
            assertEquals(
                "Not Grounded!!",
                flightStages.track()
            );
        }
    }
}
