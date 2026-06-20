package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.example.EngineType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EngineTest {

    private Engine engine;
    private static final int MIN_HORSEPOWER = 50;
    private static final int MAX_HORSEPOWER = 2000;
    private static final int MIN_TORQUE = 50;
    private static final int MAX_TORQUE = 2000;
    private static final int HORSEPOWER = 100;
    private static final int TORQUE = 100;
    private static final String NULL_ENGINE_TYPE =
        "Engine type cannot be null.";

    private static final String HORSEPOWER_RANGE =
        "Horsepower must be between " + MIN_HORSEPOWER + " and " + MAX_HORSEPOWER + ".";

    private static final String TORQUE_RANGE =
        "Torque must be between " + MIN_TORQUE + " and " + MAX_TORQUE + ".";

    @BeforeEach
    public void setUp() {
        engine = new Engine(V_EIGHT, HORSEPOWER, TORQUE);
    }

    @Nested
    @DisplayName("test engine constructor and setter type validation")
    public class TestEngineConstructorAndSetterTypeValidation {

        @Test
        public void engineConstructorRejectsNullEngineType() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(null, HORSEPOWER, TORQUE)
                );

            assertEquals(
                NULL_ENGINE_TYPE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void engineSetterRejectsNullEngineType() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> engine.setEngineType(null)
                );

            assertEquals(
                NULL_ENGINE_TYPE,
                illegalArgumentException.getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test engine constructor horsepower validation")
    public class TestEngineConstructorHorsepowerValidation {

        @Test
        public void testEngineConstructorRejectsHorsepowerTooLow() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(
                        INLINE_FOUR,
                        MIN_HORSEPOWER - 1,
                        TORQUE
                    )
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
                    () -> new Engine(
                        INLINE_SIX,
                        MAX_HORSEPOWER + 1,
                        TORQUE
                    )
                );

                assertEquals(
                    HORSEPOWER_RANGE,
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testEngineConstructorAcceptsMinimumHorsepower() {
            Engine engine = new Engine(V_SIX, MIN_HORSEPOWER, TORQUE);

            assertEquals(MIN_HORSEPOWER, engine.getHorsepower());
        }

        @Test
        public void testEngineConstructorAcceptsMaximumHorsepower() {
            Engine engine = new Engine(V_SIX, MAX_HORSEPOWER, TORQUE);

            assertEquals(MAX_HORSEPOWER, engine.getHorsepower());
        }
    }

    @Nested
    @DisplayName("test engine constructor torque validation")
    public class TestEngineConstructorTorqueValidation {

        @Test
        public void testEngineConstructorRejectsTorqueTooLow() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(
                        V_EIGHT,
                        HORSEPOWER,
                        MIN_TORQUE - 1
                    )
                );

                assertEquals(
                    TORQUE_RANGE,
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testEngineConstructorRejectsTorqueTooHigh() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Engine(
                        V_EIGHT,
                        HORSEPOWER,
                        MAX_TORQUE + 1
                    )
                );

                assertEquals(
                    TORQUE_RANGE,
                    illegalArgumentException.getMessage()
                );
        }

        @Test
        public void testEngineConstructorAcceptsMinimumTorque() {
            Engine engine = new Engine(V_SIX, HORSEPOWER, MIN_TORQUE);

            assertEquals(MIN_TORQUE, engine.getTorque());
        }

        @Test
        public void testEngineConstructorAcceptsMaximumTorque() {
            Engine engine = new Engine(V_SIX, HORSEPOWER, MAX_TORQUE);

            assertEquals(MAX_TORQUE, engine.getTorque());
        }
    }

    @Nested
    @DisplayName("test engine setter horsepower validation")
    class TestEngineSetterHorsepowerValidation {

        @Test
        public void testEngineSetterRejectsHorsepowerTooLow() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> engine.setHorsepower(MIN_HORSEPOWER - 1)
                );

            assertEquals(
                HORSEPOWER_RANGE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testEngineSetterRejectsHorsepowerTooHigh() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> engine.setHorsepower(MAX_HORSEPOWER + 1)
                );

            assertEquals(
                HORSEPOWER_RANGE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testEngineSetterAcceptsMinimumHorsepower() {
            engine.setHorsepower(MIN_HORSEPOWER);

            assertEquals(MIN_HORSEPOWER, engine.getHorsepower());
        }

        @Test
        public void testEngineSetterAcceptsMaximumHorsepower() {
            engine.setHorsepower(MAX_HORSEPOWER);

            assertEquals(MAX_HORSEPOWER, engine.getHorsepower());
        }
    }

    @Nested
    @DisplayName("test engine setter torque validation")
    class TestEngineSetterTorqueValidation {

        @Test
        public void testEngineSetterRejectsTorqueTooLow() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> engine.setTorque(MIN_TORQUE - 1)
                );

            assertEquals(
                TORQUE_RANGE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testEngineSetterRejectsTorqueTooHigh() {
            IllegalArgumentException illegalArgumentException =
                assertThrows(
                    IllegalArgumentException.class,
                    () -> engine.setTorque(MAX_TORQUE + 1)
                );

            assertEquals(
                TORQUE_RANGE,
                illegalArgumentException.getMessage()
            );
        }

        @Test
        public void testEngineSetterAcceptsMinimumTorque() {
            engine.setTorque(MIN_TORQUE);

            assertEquals(MIN_TORQUE, engine.getTorque());
        }

        @Test
        public void testEngineSetterAcceptsMaximumTorque() {
            engine.setTorque(MAX_TORQUE);

            assertEquals(MAX_TORQUE, engine.getTorque());
        }
    }
}
