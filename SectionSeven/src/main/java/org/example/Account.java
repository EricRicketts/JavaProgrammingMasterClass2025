package org.example;

class Account {
    private int number = 1234567;
    private double balance = 235.45;
    private String customerName = "John Doe";
    private String email = "john.doe@example.com";
    private String phone = "(540) 321-3456";

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance - amount < 0) {
            System.out.println("Insufficient Funds");
        } else {
            this.balance -= amount;
        }
    }
}
