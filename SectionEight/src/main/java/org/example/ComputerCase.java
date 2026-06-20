package org.example;

public class ComputerCase extends Product {

    private final String powerSupply;

    public String getPowerSupply() {
        return powerSupply;
    }

    public String pressPowerButton() {
        return "Power button pressed.";
    }

    public ComputerCase(
        String model,
        String manufacturer,
        int width,
        int height,
        int depth,
        String powerSupply
    ) {
        super(model, manufacturer, width, height, depth);
        this.powerSupply = powerSupply;
    }
}
