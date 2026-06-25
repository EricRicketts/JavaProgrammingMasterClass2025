package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideItemTest {

    SideItem fries, onionRings, salad, soup;

    @BeforeEach
    public void setUp() {
        fries = new SideItem("Fries");
        onionRings = new SideItem("Onion Rings");
        salad = new SideItem("Salad");
        soup = new SideItem("Soup");
    }

    @Nested
    @DisplayName("test fries side item")
    class TestFriesSideItem {

        @Test
        public void testGetFriesType() {
            assertEquals("fries", fries.getType());
        }

        @Test
        public void testGetFriesPrice() {
            assertEquals(new BigDecimal("2.50"), fries.getPrice());
        }
    }

    @Nested
    @DisplayName("test onion rings side item")
    class TestOnionRingsSideItem {

        @Test
        public void testGetOnionRingsType() {
            assertEquals("onion rings", onionRings.getType());
        }

        @Test
        public void testGetOnionRingsPrice() {
            assertEquals(new BigDecimal("3.00"), onionRings.getPrice());
        }
    }

    @Nested
    @DisplayName("test salad side item")
    class TestSaladSideItem {

        @Test
        public void testGetSaladType() {
            assertEquals("salad", salad.getType());
        }

        @Test
        public void testGetSaladPrice() {
            assertEquals(new BigDecimal("10.00"), salad.getPrice());
        }
    }

    @Nested
    @DisplayName("test fries side item")
    class TestSoupSideItem {

        @Test
        public void testGetSoupType() {
            assertEquals("soup", soup.getType());
        }

        @Test
        public void testGetSoupPrice() {
            assertEquals(new BigDecimal("4.00"), soup.getPrice());
        }
    }

    @Nested
    @DisplayName("test side item getters")
    class TestSideItemGetters {

        @Test
        public void testSideItemGetType() {
            assertEquals("soup", soup.getType());
        }

        @Test
        public void testSideItemGetPrice() {
            assertEquals(new BigDecimal("10.00"), salad.getPrice());
        }
    }
}
