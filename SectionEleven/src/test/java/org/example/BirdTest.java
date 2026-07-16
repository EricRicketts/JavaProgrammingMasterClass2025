package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirdTest {

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
                "Bird is being tracked.",
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
                "Bird leaves its nest.",
                flier.takeOff()
            );
        }

        @Test
        public void testLandMethodFromFlightEnabledInterface() {
            assertEquals(
                "Bird returns to its nest.",
                flier.land()
            );
        }

        @Test
        public void testFlyMethodFromFlightEnabledInterface() {
            assertEquals(
                "Bird flies.",
                flier.fly()
            );
        }
    }
}
