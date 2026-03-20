package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    Car civic, corolla, FSeries;

    @Test
    public void testFirstCar() {
        // Invoke the setters below, the describeCar method calls the getters.
        // Thus, setters and getters are fully tested.
        civic = new Car();
        civic.setMake("Honda");
        civic.setModel("Civic");
        civic.setColor("Red");
        civic.setYear(2015);
        civic.setDoors(4);
        civic.setConvertible(false);

        String expected = "make: Honda model: Civic color: " +
                "Red year: 2015 doors: 4 Not Convertible";
        String result = civic.describeCar();

        assertEquals(expected, result);
        assertEquals(1, Car.getNumberOfCars());
    }

    @Test
    public void testAddingSecondAndThirdCars() {
        corolla = new Car(); // The no-arguments constructor creates a Toyota Corolla.
        assertEquals(2, Car.getNumberOfCars());
        FSeries = new Car("Ford", "F-Series",
                "Black", 2026,
                4, false);
        // Below, the Car class calls the static method and the static variable.
        // The class is the preferred caller instead of an instance.
        assertEquals(3, Car.getNumberOfCars());
        assertFalse(Car.hasElectricDrive);

        // Shown below are discouraged coding practices, where instances
        // call static variables and static methods.  The class name should
        // prefix calls to static variables and instances.
        assertArrayEquals(new boolean[]{false, false, false},
                new boolean[]{
                        civic.hasElectricDrive,
                        corolla.hasElectricDrive,
                        FSeries.hasElectricDrive
                });
        assertEquals(3, civic.getNumberOfCars());
        // In Java static variables and static methods are shared across
        // instances and can be accessed by instances.  As noted by the
        // highlights above, this is not a good practice as the class name
        // should access static variables.  Likewise, it is best for the
        // class to call static methods.

        // Instance methods are shared across objects and allow the state
        // of each object to differ.  In this case the "model" fields of the
        // second and third instances of the Car class are different.
        assertArrayEquals(
                new String[]{"Corolla", "F-Series"},
                new String[]{corolla.getModel(), FSeries.getModel()});
    }

}
