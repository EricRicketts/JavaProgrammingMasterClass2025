package org.example;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkTest {

    @Test
    public void testParkInheritsPointMethods() {
        BigDecimal x = new BigDecimal("45.123456");
        BigDecimal y = new BigDecimal("-93.987654");
        Park park = new Park("Yellowstone", "National Park", x, y, 3);

        // Verify that we can call getX() and getY() inherited from Point
        // They should be rounded to 3 decimal places as specified in the constructor
        assertEquals(new BigDecimal("45.123"), park.getX());
        assertEquals(new BigDecimal("-93.988"), park.getY());

        // Verify that we can call render() inherited from Point
        List<BigDecimal> rendered = park.render();
        assertEquals(2, rendered.size());
        assertEquals(new BigDecimal("45.123"), rendered.get(0));
        assertEquals(new BigDecimal("-93.988"), rendered.get(1));
    }

    @Test
    public void testParkToString() {
        BigDecimal x = new BigDecimal("10.0");
        BigDecimal y = new BigDecimal("20.0");
        Park park = new Park("Central Park", "City Park", x, y, 1);

        // Should combine name, type, and the Point's toString [10.0, 20.0]
        String expected = "Central Park (City Park) [10.0, 20.0]";
        assertEquals(expected, park.toString());
    }

    @Test
    public void testParkNameAndTypeGetters() {
        BigDecimal x = new BigDecimal("45.123456");
        BigDecimal y = new BigDecimal("-93.987654");
        Park park = new Park("Yellowstone", "National Park", x, y, 3);

        assertEquals("Yellowstone", park.getName());
        assertEquals("National Park", park.getType());
    }
}
