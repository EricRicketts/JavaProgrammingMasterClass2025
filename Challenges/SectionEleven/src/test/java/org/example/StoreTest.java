package org.example;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    private Store store;
    private ProductForSale edger, trimmer, blower, mower, hedgeTrimmer;

    @BeforeEach
    public void setUp() {
        edger = new Edger(
            "Edger",
            "Battery powered Edger for lawn care",
            new BigDecimal("199.99")
        );
        blower =
            new Blower(
                "Blower",
                "Battery powered Blower for removing excess grass and leaves",
                new BigDecimal("239.99")
            );
        trimmer =
            new Trimmer(
                "Trimmer",
                "Battery powered String Trimmer for lawn care",
                new BigDecimal("229.99")
            );
        mower =
            new Mower(
                "Mower",
                "Battery powered Mower for cutting grass",
                new BigDecimal("319.99")
            );
        hedgeTrimmer =
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

            assertTrue(store.addProduct(trimmer));
            assertEquals(2, store.getProductsForSale().size());
        }

        @Test
        public void testCannotAddDuplicateProductsToStore() {
            assertEquals(1, store.getProductsForSale().size());

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

            assertTrue(store.addProduct(trimmer));
            assertEquals(2, store.getProductsForSale().size());

            ProductForSale edger = store.getProductsForSale().getFirst();
            assertTrue(store.removeProduct(edger));
            assertEquals(1, store.getProductsForSale().size());
        }

        @Test
        public void testRemoveProductFromStoreThatDoesNotExist() {
            assertEquals(1, store.getProductsForSale().size());

            assertFalse(store.removeProduct(trimmer));
            assertEquals(1, store.getProductsForSale().size());
        }
    }

    @Nested
    @DisplayName("test add OrderItem to Orders")
    class TestAddOrderItemToOrders {

        @Test
        public void testAddOrderItemToOrders() {
            Edger expectedEdger = new Edger(
                "Edger",
                "Battery powered Edger for lawn care",
                new BigDecimal("199.99")
            );
            OrderItem expectedOrderItem = new OrderItem(1, expectedEdger);

            assertEquals(0, store.getOrderItems().size());

            OrderItem edgerItem = new OrderItem(1, edger);
            store.addOrderItem(edgerItem);

            assertEquals(1, store.getOrderItems().size());
            assertEquals(expectedOrderItem, store.getOrderItems().getFirst());
        }

        @Test
        public void testAddIdenticalOrderItemIncreasesTheCount() {
            assertEquals(0, store.getOrderItems().size());

            OrderItem edgerOrderItem = new OrderItem(1, edger);
            store.addOrderItem(edgerOrderItem);
            assertEquals(1, store.getOrderItems().size());
            assertEquals(1, store.getOrderItems().getFirst().getQuantity());

            OrderItem newEdgerOrderItem = new OrderItem(2, edger);
            /*
                The addOrderItem method controls setting the number of order items.
                This is the most robust way of increasing the quantity of a given
                order item.  Note I had to instantiate a new OrderItem even though
                it was an edger, I could not take the existing edger -> edgerOrderItem
                and change its quantity.  This is because the edgerOrderItem is the
                same object in the OrderItems list index 0.  So if I change the quantity of the
                edgerOrderItem, I will also be changing the OrderItem at index 0 of the list.
                This means I will always be doubling the amount of a given OrderItem upon
                adding.  This is not what I want, I just want to increase the amount of OderItems
                to purchase just by the quantity of the newly added OrderItem.
            */
            store.addOrderItem(newEdgerOrderItem);
            assertEquals(1, store.getOrderItems().size());
            assertEquals(3, store.getOrderItems().getFirst().getQuantity());
        }
    }
}
