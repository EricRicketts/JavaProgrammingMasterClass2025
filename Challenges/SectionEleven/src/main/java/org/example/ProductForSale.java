package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class ProductForSale {

    private final String type, description;
    private BigDecimal price;

    public ProductForSale(String type, String description, BigDecimal price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalesPrice(int quantity) {
        return this.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public String printPricedItem(int quantity) {
        BigDecimal totalPrice = this.getSalesPrice(quantity);
        return "Item Quantity: " + quantity + " Item Type: " + this.getType() +
            " Total Price: " + totalPrice;
    }

    public abstract String showDetails();


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        ProductForSale other = (ProductForSale) obj;
        return Objects.equals(this.getType(), other.getType()) &&
            Objects.equals(this.getDescription(), other.getDescription()) &&
            this.getPrice().compareTo(other.getPrice()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getType(), this.getDescription(), this.getPrice());
    }
}
