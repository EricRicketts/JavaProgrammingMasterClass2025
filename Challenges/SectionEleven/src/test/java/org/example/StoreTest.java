package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    private Store store;
    ProductForSale edger, trimmer, blower, mower, hedgeTrimmer;

    @BeforeEach
    public void setUp() {
        Edger edger = new Edger(
            "Edger",
            "Battery powered Edger for lawn care",
            new BigDecimal("199.99")
        );
        ProductForSale blower =
            new Blower(
                "Blower",
                "Battery powered Blower for removing excess grass and leaves",
                new BigDecimal("239.99")
            );
        ProductForSale trimmer =
            new Trimmer(
                "Trimmer",
                "Battery powered String Trimmer for lawn care",
                new BigDecimal("229.99")
            );
        ProductForSale mower =
            new Mower(
                "Mower",
                "Battery powered Mower for cutting grass",
                new BigDecimal("319.99")
            );
        ProductForSale hedgeTrimmer =
            new HedgeTrimmer(
                "HedgeTrimmer",
                "Battery powered Hedge Trimmer for trimming bushes",
                new BigDecimal("159.99")
            );
        ArrayList<ProductForSale> productForSale = new ArrayList<>(List.of(edger));
        ArrayList<OrderItem> orders = new ArrayList<>();
        store = new Store(productForSale, orders);
    }

    @Nested
    @DisplayName("test add product to store")
    class TestAddProductToStore {

        @Test
        public void testAddProductToStore() {
            assertEquals(1, store.getProductsForSale().size());
            String description = "Battery powered Trimmer for lawn care";
            ProductForSale trimmer =
                new Trimmer("Trimmer", description, new BigDecimal("229.99"));

            assertTrue(store.addProduct(trimmer));
            assertEquals(2, store.getProductsForSale().size());
        }

        @Test
        public void testCannotAddDuplicateProductsToStore() {
            assertEquals(1, store.getProductsForSale().size());
            String description = "Battery powered Trimmer for lawn care";
            ProductForSale trimmer =
                new Trimmer("Trimmer", description, new BigDecimal("229.99"));

            assertTrue(store.addProduct(trimmer));
            assertEquals(2, store.getProductsForSale().size());

            assertFalse(store.addProduct(trimmer));
            assertEquals(2, store.getProductsForSale().size());
        }
    }

    @Nested
    @DisplayName("test remove a product from the store")
    class TestRemoveProductFromStore {

        @Test
        public void testRemoveProductFromStore() {
            assertEquals(1, store.getProductsForSale().size());
            String description = "Battery powered Trimmer for lawn care";
            ProductForSale trimmer =
                new Trimmer("Trimmer", description, new BigDecimal("229.99"));

            assertTrue(store.addProduct(trimmer));
            assertEquals(2, store.getProductsForSale().size());

            ProductForSale edger = store.getProductsForSale().getFirst();
            assertTrue(store.removeProduct(edger));
            assertEquals(1, store.getProductsForSale().size());
        }

        @Test
        public void testRemoveProductFromStoreThatDoesNotExist() {
            assertEquals(1, store.getProductsForSale().size());
            String description = "Battery powered Trimmer for lawn care";
            ProductForSale trimmer =
                new Trimmer("Trimmer", description, new BigDecimal("229.99"));

            assertFalse(store.removeProduct(trimmer));
            assertEquals(1, store.getProductsForSale().size());
        }
    }

    @Nested
    @DisplayName("test add OrderItem to Orders")
    class TestAddOrderItemToOrders {

        @Test
        public void testAddOrderItemToOrders() {

        }
    }
}
