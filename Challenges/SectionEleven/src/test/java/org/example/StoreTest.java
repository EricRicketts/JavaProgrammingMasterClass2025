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
        ArrayList<ProductForSale> productsForSale = new ArrayList<>(List.of(edger));
        ArrayList<OrderItem> orders = new ArrayList<>();
        store = new Store(productsForSale, orders);
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

    @Nested
    @DisplayName("print out store product list")
    class TestPrintOutStoreProductList {

        @Test
        public void testPrintOutStoreProductList() {
            ArrayList<ProductForSale> products = new ArrayList(List.of(
                trimmer, blower, mower, hedgeTrimmer
            ));
            for (ProductForSale product: products) store.addProduct(product);

            String expected = """
                Type: Edger
                Price: 199.99
                Description: Battery powered Edger for lawn care
                
                Type: Trimmer
                Price: 229.99
                Description: Battery powered String Trimmer for lawn care
                
                Type: Blower
                Price: 239.99
                Description: Battery powered Blower for removing excess grass and leaves
                
                Type: Mower
                Price: 319.99
                Description: Battery powered Mower for cutting grass
                
                Type: HedgeTrimmer
                Price: 159.99
                Description: Battery powered Hedge Trimmer for trimming bushes
                
                """;
            String result = store.printListOfProducts();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("print out sales receipt")
    class TestPrintOutSalesReceipt {

        @Test
        public void testPrintOutSalesReceipt() {
            String expected = """
                SALES RECEIPT
                ******************************************************
                Item Quantity: 3 Item Type: Edger Total Price: 599.97
                Item Quantity: 3 Item Type: Trimmer Total Price: 689.97
                Item Quantity: 1 Item Type: Mower Total Price: 319.99
                ******************************************************
                SubTotal: 1609.93
                Tax (5%): 80.4965
                Final Price: 1690.4265
                """;

            OrderItem firstOrderItem = new OrderItem(2, edger);
            OrderItem secondOrderItem = new OrderItem(3, trimmer);
            OrderItem thirdOrderItem = new OrderItem(1, mower);
            OrderItem fourthOrderItem = new OrderItem(1, edger);

            store.addOrderItem(firstOrderItem);
            store.addOrderItem(secondOrderItem);
            store.addOrderItem(thirdOrderItem);
            store.addOrderItem(fourthOrderItem);

            assertEquals(3, store.getOrderItems().size());
            String result = store.printSalesReceipt();

            assertEquals(expected, result);
        }
    }
}
