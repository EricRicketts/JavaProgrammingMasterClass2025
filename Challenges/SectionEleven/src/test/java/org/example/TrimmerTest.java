package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrimmerTest {

    private Trimmer trimmer;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered Trimmer for lawns";
        trimmer = new Trimmer("Trimmer", description, new BigDecimal("239.99"));
    }

    @Nested
    @DisplayName("test Trimmer getters")
    class TestTrimmerGetters {

        @Test
        public void testTrimmerGetType() {
            assertEquals("Trimmer", trimmer.getType());
        }

        @Test
        public void testTrimmerGetDescription() {
            assertEquals("Battery powered Trimmer for lawns", trimmer.getDescription());
        }

        @Test
        public void testTrimmerGetPrice() {
            assertEquals(new BigDecimal("239.99"), trimmer.getPrice());
        }
    }

    @Nested
    @DisplayName("test Trimmer setters")
    class TestTrimmerSetters {

        @Test
        public void testTrimmerSetPrice() {
            assertEquals(new BigDecimal("239.99"), trimmer.getPrice());
            trimmer.setPrice(new BigDecimal("259.99"));

            assertEquals(new BigDecimal("259.99"), trimmer.getPrice());
        }
    }

    @Nested
    @DisplayName("test Trimmer getSalesPrice method")
    class TestTrimmerSalesPrice {

        @Test
        public void testTrimmerSalesPrice() {
            BigDecimal expected = new BigDecimal("959.96");
            BigDecimal result = trimmer.getSalesPrice(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Trimmer printPricedItem method")
    class TestTrimmerPrintPricedItem {

        @Test
        public void testTrimmerPrintPricedItem() {
            String expected = "Item Quantity: 4 Item Type: Trimmer Total Price: 959.96";
            String result = trimmer.printPricedItem(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Trimmer showDetails Method")
    class TestTrimmerShowDetails {

        @Test
        public void testTrimmerShowDetailsMethod() {
            String expected = "Type: Trimmer Price: 239.99 Description: Battery powered Trimmer for lawns";
            String result = trimmer.showDetails();

            assertEquals(expected, result);
        }
    }
}
