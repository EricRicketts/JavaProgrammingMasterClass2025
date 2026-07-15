package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private Store store;

    @BeforeEach
    public void setUp() {
        Edger edger = new Edger(
            "Edger",
            "Battery powered Edger for lawn care",
            new BigDecimal("199.99")
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

            store.addProduct(trimmer);
            assertEquals(2, store.getProductsForSale().size());
        }

    }


}
