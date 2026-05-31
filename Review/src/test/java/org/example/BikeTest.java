package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    class TestBikeNoArguments {

        @Test
        public void testBikeNoArgumentsBrand() {
            assertEquals("Unknown", baseBike.getBrand());
        }

        @Test
        public void testBikeNoArgumentsSpeed() {
            assertEquals(new BigDecimal("0.00"), baseBike.getSpeed());
        }

        @Test
        public void testBikeNoArgumentsHasBell() {
            assertFalse(baseBike.getHasBell());
        }
    }

}
