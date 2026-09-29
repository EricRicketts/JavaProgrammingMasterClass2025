package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Drink implements DrinkItem {

    COKE_SMALL("Coke", "Small", new BigDecimal("1.19")),
    COKE_MEDIUM("Coke", "Medium", new BigDecimal("2.59")),
    COKE_LARGE("Coke", "Large", new BigDecimal("3.19")),
    COKE_EXTRA_LARGE("Coke", "Extra_Large", new BigDecimal("3.99")),
    PEPSI_SMALL("Pepsi", "Small", new BigDecimal("1.09")),
    PEPSI_MEDIUM("Pepsi", "Medium", new BigDecimal("2.49")),
    PEPSI_LARGE("Pepsi", "Large", new BigDecimal("3.09")),
    PEPSI_EXTRA_LARGE("Pepsi", "Extra_Large", new BigDecimal("3.89")),
    MOUNTAIN_DEW_MEDIUM("Mountain Dew", "Medium", new BigDecimal("2.59"));

    private final String name;
    private final String type;
    private final BigDecimal price;

    Drink(String name, String type, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public String getType() { return this.type; }

    @Override
    public BigDecimal getPrice() { return this.price; }

}
