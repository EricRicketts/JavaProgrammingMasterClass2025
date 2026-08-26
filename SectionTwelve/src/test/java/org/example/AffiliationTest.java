package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AffiliationTest {

    private Affiliation affiliation;

    @BeforeEach
    public void setUp() {
        affiliation = new Affiliation("Fred", "State", "US");
    }

    @Nested
    @DisplayName("test name and position getters")
    class TestNameAndPositionGetters {

        @Test
        public void testNameGetter() {
            assertEquals("Fred", affiliation.name());
        }

        @Test
        public void testStateGetter() {
            assertEquals("State", affiliation.type());
        }

        @Test
        public void testCountryCodeGetter() {
            assertEquals("US", affiliation.countryCode());
        }
    }

    @Nested
    @DisplayName("test toString")
    class TestToString {

        @Test
        public void testToString() {
            String expected = "Fred (State in US)";

            assertEquals(expected, affiliation.toString());
        }
    }

}
