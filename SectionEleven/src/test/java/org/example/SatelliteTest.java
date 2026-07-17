package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SatelliteTest {

    private Satellite satellite;

    @BeforeEach
    public void setUp() {
        satellite = new Satellite();
    }

    @Nested
    @DisplayName("test flight operations")
    class TestFlightOperations {

        @Test
        public void testTakeOff() {
            assertEquals(
                "Satellite launches.",
                satellite.takeOff()
            );
        }

        @Test
        public void testFly() {
            assertEquals(
                "Satellite flies to space.",
                satellite.fly()
            );
        }

        @Test
        public void testLand() {
            assertEquals(
                "Satellite lands.",
                satellite.land()
            );
        }
    }

    @Nested
    @DisplayName("test method unique to OrbitEarth interface")
    class TestMethodUniqueToOrbitEarthInterface {

        @Test
        public void testOrbitEarthMethodAchieveOrbit() {
            assertEquals(
                "Orbit achieved.",
                satellite.achieveOrbit()
            );
        }
    }
}
