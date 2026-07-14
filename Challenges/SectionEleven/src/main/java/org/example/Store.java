package org.example;

import java.util.ArrayList;

public class Store {

    private ArrayList<ProductForSale> productsForSale;
    private ArrayList<OrderItem> orderItems;

    public Store(ArrayList<ProductForSale> productsForSale, ArrayList<OrderItem> orderItems) {
        this.productsForSale = productsForSale;
        this.orderItems = orderItems;
    }

    public Store() {
        this.productsForSale = new ArrayList<ProductForSale>();
        this.orderItems = new ArrayList<OrderItem>();
    }

    public ArrayList<ProductForSale> getProductsForSale() {
        return productsForSale;
    }

    public void setProductsForSale(ArrayList<ProductForSale> productsForSale) {
        this.productsForSale = productsForSale;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void addProduct(ProductForSale product) {
        if (!this.getProductsForSale().contains(product)) {
            this.getProductsForSale().add(product);
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        this.getOrderItems().add(orderItem);
    }
}
