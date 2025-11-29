package org.example;

public class Customer {

    private String customerName;
    double creditLimit;
    private String customerEmail;

    public String getCustomerName() {
        return customerName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Customer() {
        this.customerName = "Elmer Fudd";
        this.creditLimit = 100.55;
        this.customerEmail = "elmer.fudd@example.com";
    }

    public Customer(String customerName, String customerEmail) {
        this(customerName, 222.22, customerEmail);
    }

    public Customer(String customerName, double creditLimit, String customerEmail) {
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.customerEmail = customerEmail;
    }
}
