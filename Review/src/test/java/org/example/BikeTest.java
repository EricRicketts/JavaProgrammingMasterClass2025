package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike baseBike;
    private Bike baseBikePlus;
    private Bike semiCustomBike;
    private Bike customBike;

    @BeforeEach
    public void setUp() {
        baseBike = new Bike();
        baseBikePlus = new Bike("SCOTT");
        semiCustomBike = new Bike("Specialized", new BigDecimal("20.12"));
        customBike = new Bike("Pinarello", new BigDecimal("21.34"), true);
    }

    @Nested
    @DisplayName("test Bike with no arguments")
    class TestBikeNoArgumentConstructor {

        @Test
        public void testBikeNoArgumentConstructorGetBrand() {
            assertEquals("Unknown", baseBike.getBrand());
        }

        @Test
        public void testBikeNoArgumentConstructorGetSpeed() {
            assertEquals(new BigDecimal("0.00"), baseBike.getSpeed());
        }

        @Test
        public void testBikeNoArgumentConstructorGetHasBell() {
            assertFalse(baseBike.getHasBell());
        }
    }

    @Nested
    @DisplayName("test Bike with single argument")
    class TestBikeSingleArgumentConstructor {

        @Test
        public void testBikeSingleArgumentConstructorGetBrand() {
            assertEquals("SCOTT", baseBikePlus.getBrand());
        }

        @Test
        public void testBikeSingleArgumentConstructorGetSpeed() {
            assertEquals(new BigDecimal("0.00"), baseBikePlus.getSpeed());
        }

        @Test
        public void testBikeSingleArgumentConstructorGetHasBell() {
            assertFalse(baseBikePlus.getHasBell());
        }
    }

    @Nested
    @DisplayName("test Bike with two arguments")
    class TestBikeTwoArgumentConstructor {

        @Test
        public void testBikeTwoArgumentConstructorGetBrand() {
            assertEquals("Specialized", semiCustomBike.getBrand());
        }

        @Test
        public void testBikeTwoArgumentConstructorGetSpeed() {
            assertEquals(new BigDecimal("20.12"), semiCustomBike.getSpeed());
        }

        @Test
        public void testBikeTwoArgumentConstructorGetHasBell() {
            assertFalse(semiCustomBike.getHasBell());
        }
    }

    @Nested
    @DisplayName("test Bike getters")
    class TestBikeGetters {

        @Test
        public void testBikeGetBrand() {
            assertEquals("Pinarello", customBike.getBrand());
        }

        @Test
        public void testBikeGetSpeed() {
            assertEquals(new BigDecimal("21.34"), customBike.getSpeed());
        }

        @Test
        public void testBikeGetHasBell() {
            assertTrue(customBike.getHasBell());
        }
    }

    @Nested
    @DisplayName("test Bike setters")
    class TestBikeSetters {

        @Test
        public void testBikeSetBrand() {
            assertEquals("Pinarello", customBike.getBrand());
            customBike.setBrand("Trek");

            assertEquals("Trek", customBike.getBrand());
        }

        @Test
        public void testBikeSetSpeed() {
            assertEquals(new BigDecimal("21.34"), customBike.getSpeed());
            customBike.setSpeed(new BigDecimal("22.45"));

            assertEquals(new BigDecimal("22.45"), customBike.getSpeed());
        }

        @Test
        public void TestBikeRejectsNegativeSpeed() {
            assertEquals(new BigDecimal("21.34"), customBike.getSpeed());
            assertThrows(
                IllegalArgumentException.class,
                () -> customBike.setSpeed(new BigDecimal("-12.34"))
            );

            assertEquals(new BigDecimal("21.34"), customBike.getSpeed());
        }
    }
}
