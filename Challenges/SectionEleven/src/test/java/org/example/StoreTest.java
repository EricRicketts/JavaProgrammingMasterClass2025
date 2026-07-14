package org.example;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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


}
