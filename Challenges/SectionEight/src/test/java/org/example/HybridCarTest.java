package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HybridCarTest {

    HybridCar hybridCar;
    String expectedString, resultantString;
    BigDecimal expected, result;

    @BeforeEach
    public void setUp() {
        hybridCar = new HybridCar(
            "Toyota Camry Hybrid 2026",
            new BigDecimal("20.40"),
            40,
            4
        );
    }

    @Nested
    @DisplayName("test hybrid car average km per litre")
    class TestHybridCarAverageKmPerLitre {

        @Test
        public void testSetAvgKmPerLitre() {
            hybridCar.setAvgKmPerLitre(new BigDecimal(-1));

            expected = new BigDecimal("20.00");
            result = NumberUtils.setScale(hybridCar.getAvgKmPerLitre(), 2);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test hybrid car getters")
    class TestHybridCarGetters {

        @Test
        public void testGetAvgKmPerLitre() {
            expected = new BigDecimal("20.40");
            result = hybridCar.getAvgKmPerLitre();

            assertEquals(expected, result);
        }

        @Test
        public void testGeBatterySize() {
            assertEquals(40, hybridCar.getBatterySize());
        }

        @Test
        public void testGetNumberOfCylinders() {
            assertEquals(4, hybridCar.getCylinders());
        }
    }

    @Nested
    @DisplayName("test hybrid car setters")
    class TestHybridCarSetters {

        @Test
        public void testSetCylinders() {
            assertEquals(4, hybridCar.getCylinders());

            hybridCar.setCylinders(6);
            assertEquals(6, hybridCar.getCylinders());
        }

        @Test
        public void testSetBatterySize() {
            assertEquals(40, hybridCar.getBatterySize());
            hybridCar.setBatterySize(75);

            assertEquals(75, hybridCar.getBatterySize());
        }

        @Test
        public void testSetAvgKmPerLitre() {
            assertEquals(new BigDecimal("20.40"), hybridCar.getAvgKmPerLitre());
            hybridCar.setAvgKmPerLitre(new BigDecimal("30.55"));

            assertEquals(new BigDecimal("30.55"), hybridCar.getAvgKmPerLitre());
        }
    }

    @Nested
    @DisplayName("test hybrid car engine")
    class TestHybridCarEngine {

        @Test
        public void testStartEngine() {
            expectedString =
                "Starting the engine on a/an HybridCar, the gas powered part" +
                    " makes noise but the battery is silent.";
            resultantString = hybridCar.startEngine();
            assertEquals(expectedString, resultantString);
        }

        @Test
        public void testRunEngine() {
            expectedString =
                "The engine of a/an HybridCar is running, when on battery only mode" +
                    " the card makes no noise.";
            resultantString = hybridCar.runEngine();
            assertEquals(expectedString, resultantString);
        }
    }

    @Nested
    @DisplayName("test driving a hybrid car")
    class TestDriveHybridCar {

        @Test
        public void testDrive() {
            expectedString = "Driving a/an HybridCar, I can get long range " +
                "with this car because of the extra power provided by the battery.";
            resultantString = hybridCar.drive();
            assertEquals(expectedString, resultantString);
        }
    }

}
