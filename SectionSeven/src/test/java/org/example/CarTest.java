package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void testCar() {
        // Invoke the setters below, the describeCar method calls the getters.
        // Thus setters and getters are fully tested.
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setColor("Red");
        car.setYear(2015);
        car.setDoors(4);
        car.setConvertible(true);

        String expected = "make: Honda model: Civic color: Red year: 2015 doors: 4 Convertible";
        String result = car.describeCar();

        assertEquals(expected, result);
    }
}
