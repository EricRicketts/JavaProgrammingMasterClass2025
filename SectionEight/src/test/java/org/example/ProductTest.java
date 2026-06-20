package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    private Product product;

    private static final String MODEL = "Model Y";
    private static final String MANUFACTURER = "Tesla";
    private static final int WIDTH = 100;
    private static final int HEIGHT = 40;
    private static final int DEPTH = 10;

    @BeforeEach
    public void setUp() {
        product = new Product(
            MODEL,
            MANUFACTURER,
            WIDTH,
            HEIGHT,
            DEPTH
        );
    }

    @Nested
    @DisplayName("test product getters")
    class TestProductGetters {

        @Test
        public void testGetModelGetter() {
            assertEquals(MODEL, product.getModel());
        }

        @Test
        public void testGetManufacturerGetter() {
            assertEquals(MANUFACTURER, product.getManufacturer());
        }

        @Test
        public void testGetWidthGetter() {
            assertEquals(WIDTH, product.getWidth());
        }

        @Test
        public void testGetHeightGetter() {
            assertEquals(HEIGHT, product.getHeight());
        }

        @Test
        public void testGetDepthGetter() {
            assertEquals(DEPTH, product.getDepth());
        }
    }
}
