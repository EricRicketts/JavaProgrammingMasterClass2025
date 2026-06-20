package org.example;

public class Engine {
    private EngineType engineType;
    private int horsepower;
    private int torque;

    private static final int MIN_HORSEPOWER = 50;
    private static final int MAX_HORSEPOWER = 2000;
    private static final int MIN_TORQUE = 50;
    private static final int MAX_TORQUE = 2000;
    private static final String NULL_ENGINE_TYPE =
        "Engine type cannot be null.";

    private static final String HORSEPOWER_RANGE =
        "Horsepower must be between " + MIN_HORSEPOWER + " and " + MAX_HORSEPOWER + ".";
    private static final String TORQUE_RANGE =
        "Torque must be between " + MIN_TORQUE + " and " + MAX_TORQUE + ".";

    public Engine(EngineType engineType, int horsepower, int torque) {
        this.engineType = validateEngineType(engineType);
        this.horsepower = validateHorsepower(horsepower);
        this.torque = validateTorque(torque);
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = validateEngineType(engineType);
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = validateHorsepower(horsepower);
    }

    public void setTorque(int torque) {
        this.torque = validateTorque(torque);
    }

    private static EngineType validateEngineType(EngineType engineType) {
        if (engineType == null) {
            throw new IllegalArgumentException(NULL_ENGINE_TYPE);
        }

        return engineType;
    }

    private static int validateHorsepower(int horsepower) {
        if (horsepower < MIN_HORSEPOWER || horsepower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(HORSEPOWER_RANGE);
        }

        return horsepower;
    }

    private static int validateTorque(int torque) {
        if (torque < MIN_TORQUE || torque > MAX_TORQUE) {
            throw new IllegalArgumentException(TORQUE_RANGE);
        }

        return torque;
    }
}