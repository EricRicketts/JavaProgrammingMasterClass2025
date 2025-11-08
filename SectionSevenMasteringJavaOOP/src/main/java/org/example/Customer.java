public class Customer {
    private String name, email;
    private double creditLimit;

    public Customer(String name, String email, double creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public Customer(String name, String address) {
        this(name,  address, 15_000.00);
    }

    public Customer() {
        this("John Doe", "john.doe@example.com", 10_000.00);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
