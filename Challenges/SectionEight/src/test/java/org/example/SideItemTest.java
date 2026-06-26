package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SideItemTest {

    SideItem fries, onionRings, salad,
        defaultSideItem, firstSideItem, secondSideItem;

    @BeforeEach
    public void setUp() {
        fries = new SideItem("Fries");
        onionRings = new SideItem("Onion Rings");
        salad = new SideItem("Salad");
        defaultSideItem = new SideItem("Default Side Item");
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
    @DisplayName("test default side item")
    class TestDefaultSideItem {

        @Test
        public void testGetDefaultSideItemType() {
            assertEquals("default side item", defaultSideItem.getType());
        }

        @Test
        public void testGetSoupPrice() {
            assertEquals(new BigDecimal("4.00"), defaultSideItem.getPrice());
        }
    }

    @Nested
    @DisplayName("test side item getters")
    class TestSideItemGetters {

        @Test
        public void testSideItemGetType() {
            assertEquals("salad", salad.getType());
        }

        @Test
        public void testSideItemGetPrice() {
            assertEquals(new BigDecimal("10.00"), salad.getPrice());
        }
    }

    @Nested
    @DisplayName("test side time equality")
    class TestSideItemEquality {

        @Test
        public void testTwoEqualSideItems() {
            firstSideItem = new SideItem("FRIES");
            secondSideItem = new SideItem("fries");

            assertEquals(firstSideItem, secondSideItem);
        }

        @Test
        public void testTwoNonEqualSideItems() {
            firstSideItem = new SideItem("fries");
            secondSideItem = new SideItem("onion rings");

            assertNotEquals(firstSideItem, secondSideItem);
        }
    }
}
