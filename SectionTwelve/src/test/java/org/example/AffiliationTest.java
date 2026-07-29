package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AffiliationTest {

    private Affiliation affiliation;

    @BeforeEach
    public void setUp() {
        affiliation = new Affiliation("Oasis", "Sports", "30");
    }

    @Test
    public void testGetAffiliationName() {
        assertEquals("Oasis", affiliation.name());
    }

    @Test
    public void testGetAffiliationType() {
        assertEquals("Sports", affiliation.type());
    }

    @Test
    public void testGetAffiliationCountryCode() {
        assertEquals("30", affiliation.countryCode());
    }

    @Test
    public void testAffiliationToString() {
        String expected = "Oasis (Sports in 30)";
        String result = affiliation.toString();

        assertEquals(expected, result);
    }
}
