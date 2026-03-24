package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    String expected, result;

    @BeforeEach
    public void setUp() {
        Wall wall1 = new Wall("Front");
        Wall wall2 = new Wall("Right");
        Wall wall3 = new Wall("Back");
        Wall wall4 = new Wall("Left");
        Ceiling ceiling = new Ceiling(120, 544);
        Bed bed = new Bed("King", 2, 36, 2, 1);
        Lamp lamp = new Lamp("Reading", false, 1500);

        bedroom = new Bedroom(
                "Master Bedroom", wall1, wall2,
                wall3, wall4, ceiling, bed, lamp);
    }

    @Test
    public void testBedRoomMakingBed() {
        expected = "Bedroom -> Making bed | Bed -> Making | ";
        result = bedroom.makeBed();
        assertEquals(expected, result);
    }

    @Test
    public void testBedRoomGetLamp() {
        expected = "Lamp -> Turning on";
        result = bedroom.getLamp().turnOn();
        assertEquals(expected, result);
    }
}
