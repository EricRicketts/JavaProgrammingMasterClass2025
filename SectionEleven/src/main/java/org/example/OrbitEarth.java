package org.example;

public interface OrbitEarth extends FlightEnabled {

    String achieveOrbit();

    private static String log(String description) {
        var today = new java.util.Date();
        return today + "\n" + description + "\n";
    }

    default String logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        return log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        return FlightEnabled.super.transition(stage);
    }
}
