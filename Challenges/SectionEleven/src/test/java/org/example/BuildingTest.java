package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.example.UsageType.FINANCE;
import static org.example.UsageType.RETAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildingTest {

    private Building building;

    @BeforeEach
    public void setUp() {
        building = new Building("Excelsior", FINANCE);
    }

    @Nested
    @DisplayName("test building getters")
    class TestBuildingGetters {

        @Test
        public void testBuildingNameGetter() {
            assertEquals("Excelsior", building.getName());
        }

        @Test
        public void testBuildingUsageTypeGetter() {
            assertEquals(FINANCE, building.getUsage());
        }
    }

    @Nested
    @DisplayName("test building setters")
    class TestBuildingSetters {

        @Test
        public void testSetBuildingName() {
            assertEquals("Excelsior", building.getName());
            building.setName("Regional Mist");

            assertEquals("Regional Mist", building.getName());
        }

        @Test
        public void testSetBuildingUsage() {
            assertEquals(FINANCE, building.getUsage());
            building.setUsage(RETAIL);

            assertEquals(RETAIL, building.getUsage());
        }
    }

    @Nested
    @DisplayName("test building toJSON")
    class TestBuildingToJSON {

        @Test
        public void testBuildingToJSON() {
            String expected = """
                "properties": {"type": "POINT", "label": "Excelsior (FINANCE)",""" + " " +
                """
                "marker": "RED DIAMOND", "name": "Excelsior", "usage": "FINANCE"}""";
            String result = Mappable.mapIt(building);

            assertEquals(expected, result);
        }
    }
}
