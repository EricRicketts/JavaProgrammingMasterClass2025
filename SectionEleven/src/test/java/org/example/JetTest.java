package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JetTest {

    private static String inFlight(FlightEnabled flier) {
        String output = flier.takeOff() + "\n" + flier.fly() + "\n";
        if (flier instanceof Trackable tracked) {
            output += tracked.track() + "\n";
        }
        output += flier.land();

        return output;
    }

    private Jet jet;

    @BeforeEach
    public void setUp() {
        jet = new Jet();
    }

    @Nested
    @DisplayName("test implemented methods from abstract Animal class")
    class TestAbstractClassMethod {

        @Test
        public void testAbstractClassMethod() {
            assertEquals(
                "Jet main type of movement is to fly.",
                jet.move()
            );
        }
    }

    @Nested
    @DisplayName("test inFlight method")
    class TestInFlightMethod {

        @Test
        public void testInFlightMethod() {
            String expected = """
                Jet takes off.
                Jet is flying.
                Jet coordinates recorded.
                Jet is landing.""";
            String result = inFlight(jet);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test access to constants in interface")
    class TestAccessToConstantsInInterface {

        @Test
        public void testAccessToMilesToKm() {
            assertEquals(
                new BigDecimal("160.934"),
                new BigDecimal("100").multiply(FlightEnabled.MILES_TO_KM)
                    .setScale(3, RoundingMode.HALF_UP)
            );
        }

        @Test
        public void testAccessToKmToMiles() {
            assertEquals(
                new BigDecimal("62.1371"),
                new BigDecimal("100").multiply(FlightEnabled.KM_TO_MILES)
                    .setScale(4, RoundingMode.HALF_UP)
            );
        }
    }
}
