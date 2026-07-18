package org.example;

public class Satellite implements OrbitEarth {
    @Override
    public String achieveOrbit() {
        return "Orbit achieved.";
    }

    @Override
    public String takeOff() {
        return this.getClass().getSimpleName() + " launches.";
    }

    @Override
    public String land() {
        return this.getClass().getSimpleName() + " lands.";
    }

    @Override
    public String fly() {
        return this.getClass().getSimpleName() + " flies to space.";
    }

    static String log(String description) {
        return OrbitEarth.log(description);
    }
}
