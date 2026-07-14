package org.example;

import java.util.Objects;

public class OrderItem {

    private int quantity;
    private ProductForSale productForSale;

    public OrderItem(int quantity, ProductForSale productForSale) {
        this.quantity = quantity;
        this.productForSale = productForSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductForSale getProductForSale() {
        return productForSale;
    }

    public void setProductForSale(ProductForSale productForSale) {
        this.productForSale = productForSale;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        OrderItem other = (OrderItem) obj;
        return this.quantity == other.quantity &&
            Objects.equals(this.getProductForSale(), other.getProductForSale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getQuantity(), this.getProductForSale());
    }
}
