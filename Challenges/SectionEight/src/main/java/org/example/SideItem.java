package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class SideItem {

    private final String type;
    private final BigDecimal price;

    public SideItem(String type) {
        this.type = type.toLowerCase();
        switch (this.type) {
            case "fries" -> this.price = new BigDecimal("2.50");
            case "onion rings" -> this.price = new BigDecimal("3.00");
            case "salad" -> this.price = new BigDecimal("10.00");
            default -> this.price = new BigDecimal("4.00");
        }
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        SideItem other = (SideItem) obj;

        return Objects.equals(this.getType(), other.getType()) &&
            Objects.equals(this.getPrice(), other.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getType(), this.getPrice());
    }
}
