package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgerTest {

    private Edger edger;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered Edger for lawns.";
        edger = new Edger("Edger", description, new BigDecimal("239.99"));
    }

    @Nested
    @DisplayName("test Edger getters")
    class TestEdgerGetters {

        @Test
        public void testEdgerGetType() {
            assertEquals("Edger", edger.getType());
        }

        @Test
        public void testEdgerGetDescription() {
            assertEquals("Battery powered Edger for lawns.", edger.getDescription());
        }

        @Test
        public void testEdgerGetPrice() {
            assertEquals(new BigDecimal("239.99"), edger.getPrice());
        }
    }

    @Nested
    @DisplayName("test Edger setters")
    class TestEdgerSetters {

        @Test
        public void testEdgerSetType() {
            assertEquals("Edger", edger.getType());
            edger.setType("Trimmer");

            assertEquals("Trimmer", edger.getType());
        }

        @Test
        public void testEdgerSetDescription() {
            assertEquals("Battery powered Edger for lawns.", edger.getDescription());
            edger.setDescription("Battery powered Trimmer for lawns.");

            assertEquals("Battery powered Trimmer for lawns.", edger.getDescription());
        }

        @Test
        public void testEdgerSetPrice() {
            assertEquals(new BigDecimal("239.99"), edger.getPrice());
            edger.setPrice(new BigDecimal("259.99"));

            assertEquals(new BigDecimal("259.99"), edger.getPrice());
        }
    }

    @Nested
    @DisplayName("test Edger getSalesPrice method")
    class TestEdgerSalesPrice {

        @Test
        public void testEdgerSalesPrice() {
            BigDecimal expected = new BigDecimal("959.96");
            BigDecimal result = edger.getSalesPrice(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Edger printPricedItem method")
    class TestEdgerPrintPricedItem {

        @Test
        public void testEdgerPrintPricedItem() {
            String expected = "Item Quantity: 4 Item Type: Edger Total Price: 959.96";
            String result = edger.printPricedItem(4);

            assertEquals(expected, result);
        }
    }
}
