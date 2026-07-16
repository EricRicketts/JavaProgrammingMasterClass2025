package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragonFlyTest {

    private DragonFly dragonfly;

    @BeforeEach
    public void setUp() {
        dragonfly = new DragonFly("Generic", "Large");
    }

    @Nested
    @DisplayName("test behavior")
    class TestFlightOperations {

        @Test
        public void testTakeOff() {
            assertEquals(
                "DragonFly takes off from flower.",
                dragonfly.takeOff()
            );
        }

        @Test
        public void testFly() {
            assertEquals(
                "DragonFly is hovering around the flower.",
                dragonfly.fly()
            );
        }

        @Test
        public void testLand() {
            assertEquals(
                "DragonFly lands on the flower.",
                dragonfly.land()
            );
        }
    }

}
