package org.example;

public class Account {

    private double balance;
    private String accountNumber, accountHolder, email, phoneNumber;

    public Account() {
        // The default constructor makes a call to the five-parameter constructor.
        // In this case we defined our own default constructor instead of taking
        // Java's default constructor, which the language implicitly provides.
        // The call to another constructor must be the first line in a constructor
        // body, and it must use the keyword "this".  Note parameters must be used
        // in the constructor call in the body of the constructor if the called
        // constructor requires them.
        this("56789", 2.5,
                "Default Name", "Default Email",
                "Default Phone"
        );
    }

    public Account(String number, double balance, String customerName,
                   String email, String phone
    ) {
        this.accountNumber = number;
        this.balance = balance;
        this.accountHolder = customerName;
        this.email = email;
        this.phoneNumber = phone;
    }

    public Account(String accountHolder, String email, String phoneNumber) {
        // The three-argument constructor calls the five-argument constructor
        // with two default values.
        this("99999", 100.55, accountHolder, email, phoneNumber);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String withdraw(double amount) {
        if (balance < amount) {
            return "Insufficient Funds";
        } else {
            balance -= amount;
        }
        return "Withdrawal successful";
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
