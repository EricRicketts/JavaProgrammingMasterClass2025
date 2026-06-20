package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.example.EngineType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EngineTest {

    private static final int MIN_HORSEPOWER = 50;
    private static final int MAX_HORSEPOWER = 2000;
    private static final int MIN_TORQUE = 50;
    private static final int MAX_TORQUE = 2000;
    private static final String NULL_ENGINE_TYPE =
        "Engine type cannot be null.";

    private static final String HORSEPOWER_RANGE =
        "Horsepower must be between " + MIN_HORSEPOWER + " and " + MAX_HORSEPOWER + ".";

    private static final String TORQUE_RANGE =
        "Torque must be between " + MIN_TORQUE + " and " + MAX_TORQUE + ".";

    @Nested
    @DisplayName("test engine type validation")
    public class TestEngineTypeValidation {

        @Test
        public void engineConstructorRejectsNullEngineType() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(null, 100, 100)
                );

            assertEquals(
                NULL_ENGINE_TYPE,
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test engine constructor horsepower validation")
    public class TestHorsepowerValidation {

        @Test
        public void testEngineConstructorRejectsHorsepowerTooLow() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(INLINE_FOUR, 49, 100)
                );

                assertEquals(
                    HORSEPOWER_RANGE,
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testEngineConstructorRejectsHorsepowerTooHigh() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(INLINE_SIX, 2001, 100)
                );

            assertEquals(
                HORSEPOWER_RANGE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testEngineConstructorAcceptsMinimumHorsepower() {
            Engine engine = new Engine(V_SIX, MIN_HORSEPOWER, 100);

            assertEquals(MIN_HORSEPOWER, engine.getHorsepower());
        }

        @Test
        public void testEngineConstructorAcceptsMaximumHorsepower() {
            Engine engine = new Engine(V_SIX, MAX_HORSEPOWER, 100);

            assertEquals(MAX_HORSEPOWER, engine.getHorsepower());
        }
    }

    @Nested
    @DisplayName("test Torque validation")
    public class TestTorqueValidation {

        @Test
        public void testEngineConstructorRejectsTorqueTooLow() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(V_EIGHT, 100, 49)
                );

                assertEquals(
                    TORQUE_RANGE,
                    illegalArgumentException.getMessage()
                );
        }
    }
}
