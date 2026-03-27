package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HybridCarTest {

    HybridCar hybridCar;

    @BeforeEach
    public void setUp() {
        hybridCar = new HybridCar(25.00, 60, 6);
    }

    @Test
    public void testSetAvgKmPerLitre() {
        hybridCar.setAvgKmPerLitre(-1);
        assertEquals(20.00, Scale.setScale(hybridCar.getAvgKmPerLitre(), 2));
    }
}
