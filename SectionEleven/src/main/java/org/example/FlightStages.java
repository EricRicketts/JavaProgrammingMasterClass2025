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
}