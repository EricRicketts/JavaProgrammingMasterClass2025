package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HedgeTrimmerTest {

    private HedgeTrimmer hedgeTrimmer;

    @BeforeEach
    public void setUp() {
        String description = "Battery powered HedgeTrimmer for trimming bushes";
        hedgeTrimmer = new HedgeTrimmer("HedgeTrimmer", description, new BigDecimal("159.99"));
    }

    @Nested
    @DisplayName("test HedgeTrimmer getters")
    class TestHedgeTrimmerGetters {

        @Test
        public void testHedgeTrimmerGetType() {
            assertEquals("HedgeTrimmer", hedgeTrimmer.getType());
        }

        @Test
        public void testHedgeTrimmerGetDescription() {
            assertEquals("Battery powered HedgeTrimmer for trimming bushes", hedgeTrimmer.getDescription());
        }

        @Test
        public void testHedgeTrimmerGetPrice() {
            assertEquals(new BigDecimal("159.99"), hedgeTrimmer.getPrice());
        }
    }

    @Nested
    @DisplayName("test HedgeTrimmer setters")
    class TestHedgeTrimmerSetters {

        @Test
        public void testHedgeTrimmerSetPrice() {
            assertEquals(new BigDecimal("159.99"), hedgeTrimmer.getPrice());
            hedgeTrimmer.setPrice(new BigDecimal("169.99"));

            assertEquals(new BigDecimal("169.99"), hedgeTrimmer.getPrice());
        }
    }

    @Nested
    @DisplayName("test HedgeTrimmer getSalesPrice method")
    class TestHedgeTrimmerSalesPrice {

        @Test
        public void testHedgeTrimmerSalesPrice() {
            BigDecimal expected = new BigDecimal("639.96");
            BigDecimal result = hedgeTrimmer.getSalesPrice(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test HedgeTrimmer printPricedItem method")
    class TestHedgeTrimmerPrintPricedItem {

        @Test
        public void testHedgeTrimmerPrintPricedItem() {
            String expected = "Item Quantity: 4 Item Type: HedgeTrimmer Total Price: 639.96";
            String result = hedgeTrimmer.printPricedItem(4);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test HedgeTrimmer showDetails Method")
    class TestHedgeTrimmerShowDetails {

        @Test
        public void testHedgeTrimmerShowDetailsMethod() {
            String description = "Battery powered HedgeTrimmer for trimming bushes";
            String expected = "Type: HedgeTrimmer\nPrice: 159.99\nDescription: " + description + "\n";
            String result = hedgeTrimmer.showDetails();

            assertEquals(expected, result);
        }
    }
}
