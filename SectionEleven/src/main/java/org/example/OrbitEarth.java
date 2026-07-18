package org.example;

public interface OrbitEarth extends FlightEnabled {

    String achieveOrbit();

    static String log(String description) {
        var today = new java.util.Date();
        return today + "\n" + description + "\n";
    }
}
