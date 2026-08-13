package org.example;

import java.math.BigDecimal;

public enum Side implements SideItem {

    FRIES_SMALL("Fries", "Small", new BigDecimal("1.59")),
    FRIES_MEDIUM("Fries", "Medium", new BigDecimal("1.99")),
    FRIES_LARGE("Fries", "Large", new BigDecimal("2.29")),
    ONION_RINGS_SMALl("Onion Rings", "Small", new BigDecimal("1.79")),
    ONION_RINGS_MEDIUM("Onion Rings", "Medium", new BigDecimal("2.19")),
    ONION_RINGS_LARGE("Onion Rings", "Large", new BigDecimal("2.49")),
    SIDE_SALAD_SMALL("Side Salad", "Small", new BigDecimal("2.59")),
    SIDE_SALAD_MEDIUM("Side Salad", "Medium", new BigDecimal("3.09")),
    SIDE_SALAD_LARGE("Side Salad", "Large", new BigDecimal("3.59"));


    private final String name;
    private final String type;
    private final BigDecimal price;

    Side(String name, String type, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
