package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductForSaleTest {

    private ProductForSale product;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered Edger for lawns.";
        product = new ProductForSale("Edger", description, new BigDecimal("239.99"));
    }

    @Nested
    @DisplayName("test ProductForSale getters")
    class TestProductForSaleGetters {

        @Test
        public void testProductForSaleGetType() {
            assertEquals("Edger", product.getType());
        }

        @Test
        public void testProductForSaleGetDescription() {
            assertEquals("Battery powered Edger for lawns.", product.getDescription());
        }

        @Test
        public void testProductForSaleGetPrice() {
            assertEquals(new BigDecimal("239.99"), product.getPrice());
        }
    }

    @Nested
    @DisplayName("test ProductForSale setters")
    class TestProductForSaleSetters {

        @Test
        public void testProductForSaleSetType() {
            assertEquals("Edger", product.getType());
            product.setType("Trimmer");

            assertEquals("Trimmer", product.getType());
        }

        @Test
        public void testProductForSaleSetDescription() {
            assertEquals("Battery powered Edger for lawns.", product.getDescription());
            product.setDescription("Battery powered Trimmer for lawns.");

            assertEquals("Battery powered Trimmer for lawns.", product.getDescription());
        }

        @Test
        public void testProductForSaleSetPrice() {
            assertEquals(new BigDecimal("239.99"), product.getPrice());
            product.setPrice(new BigDecimal("259.99"));

            assertEquals(new BigDecimal("259.99"), product.getPrice());
        }
    }
}
