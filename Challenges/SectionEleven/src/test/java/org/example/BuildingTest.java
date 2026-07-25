package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.UsageType.FINANCE;
import static org.example.UsageType.RETAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildingTest {

    private Building building;
    private List<Mappable> buildings = new ArrayList<>();
    String[] expectedJSON = new String[]{
       """
       "properties": {"type": "POINT", "label": "Sydney Town Hall (GOVERNMENT)",""" + " " +
        """
       "marker": "BLUE PUSH_PIN", "name": "Sydney Town Hall", "usage": "GOVERNMENT"}""",
       """
       "properties": {"type": "POINT", "label": "Sydney Opera House (ENTERTAINMENT)",""" + " " +
       """
       "marker": "GREEN TRIANGLE", "name": "Sydney Opera House", "usage": "ENTERTAINMENT"}""",
       """
       "properties": {"type": "POINT", "label": "Stadium Australia (SPORTS)",""" + " " +
       """
       "marker": "YELLOW ELLIPSE", "name": "Stadium Australia", "usage": "SPORTS"}"""
    };

    private String expected, result;

    @BeforeEach
    public void setUp() {
        building = new Building("Excelsior", FINANCE);
        buildings.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        buildings.add(new Building("Sydney Opera House", UsageType.ENTERTAINMENT));
        buildings.add(new Building("Stadium Australia", UsageType.SPORTS));
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
            expected = """
                "properties": {"type": "POINT", "label": "Excelsior (FINANCE)",""" + " " +
                """
                "marker": "RED DIAMOND", "name": "Excelsior", "usage": "FINANCE"}""";
            result = Mappable.mapIt(building);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test multiple buildings toJSON")
    class TestMultipleBuildingsToJSON {

        @Test
        public void testGovernmentBuildingJSON() {
            expected = expectedJSON[0];
            result = Mappable.mapIt(buildings.getFirst());

            assertEquals(expected, result);
        }

        @Test
        public void testGovernmentEntertainmentJSON() {
            expected = expectedJSON[1];
            result = Mappable.mapIt(buildings.get(1));

            assertEquals(expected, result);
        }

        @Test
        public void testGovernmentSportsJSON() {
            expected = expectedJSON[2];
            result = Mappable.mapIt(buildings.getLast());

            assertEquals(expected, result);
        }
    }
}
