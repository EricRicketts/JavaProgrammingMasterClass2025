package org.example;

public class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;
    @Override
    public String achieveOrbit() {
        return "Orbit achieved.";
    }

    @Override
    public String takeOff() {
        return transition("Taking Off.");
    }

    @Override
    public String land() {
        return transition("Landing.");
    }

    @Override
    public String fly() {
        return achieveOrbit() + "  Data collection while orbiting.";
    }

    public String transition(String description) {
        var nexStage = transition(stage);
        nexStage.track();
        return description;
    }
}
