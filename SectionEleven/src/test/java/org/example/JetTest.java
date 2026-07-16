package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}
