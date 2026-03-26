package org.example;

public class Car {

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public String startEngine() {
        return "Starting engine on a " + this.getClass().getSimpleName() + ".";
    }

    public String drive() {
        return "Driving a/an " + this.getClass().getSimpleName() + ".";
    }

    protected String runEngine() {
        return "The engine of a/an " + this.getClass().getSimpleName() + " is running.";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
