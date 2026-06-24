package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideItemTest {

    SideItem fries, onionRings, salad, soup;

    @BeforeEach
    public void setUp() {
        fries = new SideItem("Fries");
        onionRings = new SideItem("Onion Rings");
        salad = new SideItem("Salad");
        soup = new SideItem("Soup");
    }

    @Test
    public void testToppingTypeAndPrices() {
        String[] sideItems = {"Fries", "Onion Rings", "Salad", "Soup"};
        String[] expectedSideItemTypes = {"fries", "onion rings", "salad", "soup"};
        BigDecimal[] expectedPrices = {
            new BigDecimal("2.50"),
            new BigDecimal("3.00"),
            new BigDecimal("10.00"),
            new BigDecimal("4.00")
        };
        for (int i = 0; i < sideItems.length; i++) {
            SideItem sideItem = new SideItem(sideItems[i]);
            String expectedSideItemType = expectedSideItemTypes[i].toLowerCase();
            BigDecimal expectedPrice = expectedPrices[i];
            String sideItemType = sideItem.getType();
            BigDecimal sideItemPrice = sideItem.getPrice();
            assertEquals(expectedSideItemType, sideItemType);
            assertEquals(expectedPrice, sideItemPrice);
        }
    }
}
