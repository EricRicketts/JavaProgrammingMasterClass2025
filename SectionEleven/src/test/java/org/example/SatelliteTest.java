package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Nested
    @DisplayName("test FlightEnabled constants")
    class TestFlightEnabledConstants {

        @Test
        public void testKMToMilesConstant() {
            BigDecimal expected = new BigDecimal("1.60934");
            BigDecimal result = OrbitEarth.MILES_TO_KM;

            assertEquals(expected, result);
        }

        @Test
        public void testMilesToKMConstant() {
            BigDecimal expected = new BigDecimal("0.621371");
            BigDecimal result = OrbitEarth.KM_TO_MILES;

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test log method")
    class TestLogMethod {

        @Test
        public void testLogMethod() {
            Pattern pattern = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
            String description = "Testing logging is working.";
            String log = Satellite.log(description);

            String splitText = log.split("\n")[0];
            Matcher matcher = pattern.matcher(splitText);

            assertTrue(matcher.find(), "Pattern " + pattern.pattern() + " should match " + splitText);
            assertTrue(log.contains("Testing logging is working"));
        }
    }
}
