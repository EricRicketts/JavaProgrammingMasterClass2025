package org.example;

public class PersonalComputer extends Product {

    private final Monitor monitor;
    private final Motherboard motherboard;
    private final ComputerCase computerCase;

    public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public PersonalComputer(
        String model,
        String manufacturer,
        int width,
        int height,
        int depth,
        Monitor monitor,
        Motherboard motherboard,
        ComputerCase computerCase
    ) {
        super(model, manufacturer, width, height, depth);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;
    }
}
