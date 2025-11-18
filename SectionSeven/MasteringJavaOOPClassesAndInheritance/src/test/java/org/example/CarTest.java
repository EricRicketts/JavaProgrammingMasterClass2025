package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarTest {
    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car();
        car.setMake("BMW");
        car.setModel("320i");
        car.setColor("Black");
        car.setDoors(4);
        car.setConvertable(false);
    }

    @Test
    public void testGetMakeAndModel() {
        List<String> expected = List.of("BMW", "320i");
        List<String> result = List.of(car.getMake(), car.getModel());

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDescribeCar() {
        String expected = "4-Door Black BMW 320i Not Convertible";
        String result = car.describeCar();
        Assertions.assertEquals(expected,result);
    }
}
