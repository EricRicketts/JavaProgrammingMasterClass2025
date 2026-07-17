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

    @Nested
    @DisplayName("test FlightStages constants")
    class TestFlightStagesConstants {

        @Test
        public void testFlightStagesGROUNDED() {
            assertEquals(
                FlightStages.GROUNDED,
                FlightStages.valueOf("GROUNDED")
            );

            assertEquals(
                "GROUNDED",
                FlightStages.GROUNDED.name()
            );

            assertEquals(
                0,
                FlightStages.GROUNDED.ordinal()
            );
        }

        @Test
        public void testFlightStagesLAUNCH() {
            assertEquals(
                FlightStages.LAUNCH,
                FlightStages.valueOf("LAUNCH")
            );

            assertEquals(
                "LAUNCH",
                FlightStages.LAUNCH.name()
            );

            assertEquals(
                1,
                FlightStages.LAUNCH.ordinal()
            );
        }

        @Test
        public void testFlightStagesCRUISE() {
            assertEquals(
                FlightStages.CRUISE,
                FlightStages.valueOf("CRUISE")
            );

            assertEquals(
                "CRUISE",
                FlightStages.CRUISE.name()
            );

            assertEquals(
                2,
                FlightStages.CRUISE.ordinal()
            );
        }

        @Test
        public void testFlightStagesDATA_COLLECTION() {
            assertEquals(
                FlightStages.DATA_COLLECTION,
                FlightStages.valueOf("DATA_COLLECTION")
            );

            assertEquals(
                "DATA_COLLECTION",
                FlightStages.DATA_COLLECTION.name()
            );

            assertEquals(
                3,
                FlightStages.DATA_COLLECTION.ordinal()
            );
        }
    }
}
