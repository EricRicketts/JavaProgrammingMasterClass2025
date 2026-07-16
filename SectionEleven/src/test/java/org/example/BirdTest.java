package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirdTest {

    private static String inFlight(FlightEnabled flier) {
        String output = flier.takeOff() + "\n" + flier.fly() + "\n";
        if (flier instanceof Trackable tracked) {
            output += tracked.track() + "\n";
        }
        output += flier.land();

        return output;
    }

    private Bird bird;
    private Animal animal;
    private FlightEnabled flier;
    private Trackable tracked;

    @BeforeEach
    public void setUp() {
        bird = new Bird();
        animal = bird;
        flier = bird;
        tracked = bird;
    }

    @Nested
    @DisplayName("test implemented methods from abstract Animal class")
    class TestAbstractClassMethod {

        @Test
        public void testAbstractClassMethod() {
            assertEquals(
                "Bird main type of movement is to fly.",
                animal.move()
            );
        }
    }

    @Nested
    @DisplayName("test implemented methods from Trackable Interface")
    class TestImplementedMethodsFromTrackableInterface {

        @Test
        public void testAbstractMethodsFromTrackableInterface() {
            assertEquals(
                "Bird coordinates recorded.",
                tracked.track()
            );
        }
    }

    @Nested
    @DisplayName("test implemented methods from FlightEnabled Interface")
    class TestImplementedMethodsFromFlightEnabledInterface {

        @Test
        public void testTakeOffMethodFromFlightEnabledInterface() {
            assertEquals(
                "Bird takes off.",
                flier.takeOff()
            );
        }

        @Test
        public void testLandMethodFromFlightEnabledInterface() {
            assertEquals(
                "Bird is landing.",
                flier.land()
            );
        }

        @Test
        public void testFlyMethodFromFlightEnabledInterface() {
            assertEquals(
                "Bird is flying.",
                flier.fly()
            );
        }
    }

    @Nested
    @DisplayName("test inFlight method")
    class TestInFlightMethod {

        @Test
        public void testInFlightMethod() {
            String expected = """
                Bird takes off.
                Bird is flying.
                Bird coordinates recorded.
                Bird is landing.""";
            String result = inFlight(flier);

            assertEquals(expected, result);
        }
    }
}
