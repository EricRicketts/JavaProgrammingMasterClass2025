package org.example;

import java.math.BigDecimal;
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

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public boolean addProduct(ProductForSale product) {
        if (!this.getProductsForSale().contains(product)) {
            return this.getProductsForSale().add(product);
        }
        return false;
    }

    public boolean removeProduct(ProductForSale product) {
        return this.getProductsForSale().remove(product);
    }

    public void addOrderItem(OrderItem orderItem) {
        ProductForSale productToAdd = orderItem.getProductForSale();
        for (OrderItem existingOrderItem : orderItems) {
            ProductForSale existingProductForSale = existingOrderItem.getProductForSale();
            if (productToAdd.equals(existingProductForSale)) {
                int quantityToAdd = orderItem.getQuantity();
                int currentQuantity = existingOrderItem.getQuantity();
                existingOrderItem.setQuantity(currentQuantity + quantityToAdd);
                return;
            }
        }
        this.getOrderItems().add(orderItem);
    }

    public String printListOfProducts() {
        String listOfProducts = "";
        for (ProductForSale productForSale : productsForSale) {
            listOfProducts = listOfProducts.concat(productForSale.showDetails() + "\n");
        }
        return listOfProducts;
    }

    public String printSalesReceipt() {
        String salesReceipt = "SALES RECEIPT\n******************************************************\n";
        BigDecimal taxRate = new BigDecimal("0.05");
        BigDecimal subTotal = this.calculateSubTotal();

        BigDecimal tax = taxRate.multiply(subTotal);
        BigDecimal finalPrice = tax.add(subTotal);

        for (OrderItem orderItem : this.getOrderItems()) {
            ProductForSale productForSale = orderItem.getProductForSale();
            int productQuantity = orderItem.getQuantity();
            String lineItem = productForSale.printPricedItem(productQuantity).concat("\n");
            salesReceipt = salesReceipt.concat(lineItem);
        }
        salesReceipt = salesReceipt.concat("******************************************************\n")
            .concat("SubTotal: " + subTotal + "\n")
            .concat("Tax (5%): " + tax + "\n")
            .concat("Final Price: " + finalPrice + "\n");

        return salesReceipt;
    }

    private BigDecimal calculateSubTotal() {
        BigDecimal subTotal = new BigDecimal("0.00");
        for (OrderItem orderItem : this.getOrderItems()) {
            BigDecimal totalSalesPriceForOrderItem =
                orderItem
                    .getProductForSale()
                    .getPrice()
                    .multiply(BigDecimal.valueOf(orderItem.getQuantity())
                    );
            subTotal = subTotal.add(totalSalesPriceForOrderItem);
        }
        return subTotal;
    }

    private BigDecimal calculateTax(BigDecimal subTotal, BigDecimal taxRate) {
        return subTotal.multiply(taxRate);
    }
}
