package org.example;

import java.math.BigDecimal;

public interface FlightEnabled {

    BigDecimal MILES_TO_KM = new BigDecimal("1.60934");

    BigDecimal KM_TO_MILES = new BigDecimal("0.621371");
    public abstract String takeOff();

    abstract String land();

    String fly(); // In an interface all methods by default are public and abstract.
}
