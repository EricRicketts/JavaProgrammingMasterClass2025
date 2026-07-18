package org.example;
public enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;


    @Override
    public String track() {
        if (this != GROUNDED) {
            return "Monitoring " + this.getClass().getSimpleName();
        }
        else {
            return "Not Grounded!!";
        }
    }

    public FlightStages getNextStage() {
        FlightStages[] allStages = values();
        // Code wraps around to the first stage when at the last stage.
        return allStages[(ordinal() + 1) % allStages.length];
    }
}