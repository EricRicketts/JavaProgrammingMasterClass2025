package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarTest {
    Car firstCar, secondCar, thirdCar;

    @BeforeEach
    public void setUp() {
        firstCar = new Car("Honda", "Civic", "blue", 4, false);
        secondCar = new Car("Ford", "Mustang", "black");
        thirdCar = new Car("Chevrolet", "Camaro");
    }

    @Test
    public void testGetDoors() {
        List<Integer> expectedDoors =  Arrays.asList(2, 2);
        List<Integer> actualDoors = Arrays.asList(secondCar.getDoors(), thirdCar.getDoors());
        Assertions.assertEquals(expectedDoors, actualDoors);
    }

    @Test
    public void testGetConvertibles() {
        List<Boolean> expectedConvertibles =  Arrays.asList(false, false);
        List<Boolean> actualConvertibles = Arrays.asList(
                secondCar.isConvertible(), thirdCar.isConvertible()
        );
        Assertions.assertEquals(expectedConvertibles, actualConvertibles);
    }

    @Test
    public void testGetAndSetMake() {
        String expectedMake = "Honda";
        String actualMake = firstCar.getMake();
        Assertions.assertEquals(expectedMake, actualMake);
        firstCar.setMake("Toyota");
        expectedMake = "Toyota";
        actualMake = firstCar.getMake();
        Assertions.assertEquals(expectedMake, actualMake);
    }

    @Test
    public void testDescribeCar() {
        String expected = "4-Door blue Honda Civic Not Convertible";
        String actual = firstCar.describeCar();
        Assertions.assertEquals(expected, actual);
    }
}
