package org.example;

public class Motherboard extends Product {

    private final int ramSlots;
    private final int cardSlots;
    private final String bios;

    public int getRamSlots() {
        return ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public String getBios() {
        return bios;
    }

    public String loadProgram(String programName) {
        return "Loading Program " + programName + ".";
    }

    public Motherboard(
        String model,
        String manufacturer,
        int width,
        int height,
        int depth,
        int ramSlots,
        int cardSlots,
        String bios
    ) {
        super(model, manufacturer, width, height, depth);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }
}
