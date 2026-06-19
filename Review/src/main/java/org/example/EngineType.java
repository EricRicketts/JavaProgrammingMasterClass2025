package org.example;

public enum EngineType {
    INLINE_FOUR(4, "Inline"),
    INLINE_SIX(6, "Inline"),
    V_SIX(6, "V"),
    V_EIGHT(8, "V"),
    V_TWELVE(12, "V"),
    FLAT_TEN(10, "Flat");

    private final int numberOfCylinders;

    private final String cylinderArrangement;

    EngineType(int numberOfCylinders, String cylinderArrangement) {
        this.numberOfCylinders = numberOfCylinders;
        this.cylinderArrangement = cylinderArrangement;
    }

    public int getNumberOfCylinders() {
        return this.numberOfCylinders;
    }

    public String getCylinderArrangement() {
        return this.cylinderArrangement;
    }
}
