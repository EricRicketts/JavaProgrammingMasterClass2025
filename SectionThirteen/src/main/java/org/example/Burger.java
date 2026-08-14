package org.example;

import java.math.BigDecimal;

public class Burger {

    private BurgerMeatType meatType;
    private BurgerSize size;
    private BigDecimal price;
    public Burger(BurgerMeatType meatType, BurgerSize size, BigDecimal price) {
        this.meatType = meatType;
        this.size = size;
        this.price = price;
    }

    public BurgerMeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(BurgerMeatType meatType) {
        this.meatType = meatType;
    }

    public BurgerSize getSize() {
        return size;
    }

    public void setSize(BurgerSize size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Burger: ").append("\n")
            .append("Meat Type: ").append(this.getMeatType().name()).append("\n")
            .append("Burger Size: ").append(this.getSize().name()).append("\n");

        return sb.toString();
    }
}
