package org.example;

import java.math.BigDecimal;

public class ProductForSale {

    private String type, description;
    private BigDecimal price;

    public ProductForSale(String type, String description, BigDecimal price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
