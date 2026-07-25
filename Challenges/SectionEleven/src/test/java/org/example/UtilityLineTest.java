package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.UtilityType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityLineTest {

    List<Mappable> utilities = new ArrayList<>();
    UtilityLine utility, fiberOptic, water, electrical;
    String expected, result;

    @BeforeEach
    public void setUp() {
        utilities.add(new UtilityLine("College Street", FIBER_OPTIC));
        utilities.add(new UtilityLine("Olympic Boulevard", UtilityType.WATER));
        utilities.add(new UtilityLine("Main Street", UtilityType.ELECTRICAL));
        utility = (UtilityLine) utilities.getFirst();
        fiberOptic = (UtilityLine) utilities.getFirst();
        water = (UtilityLine) utilities.get(1);
        electrical = (UtilityLine) utilities.getLast();
    }

    @Nested
    @DisplayName("test UtilityLine getters")
    class TestUtilityLineGetters {

        @Test
        public void testUtilityLineGetName() {
            assertEquals("College Street", utility.getName());
        }

        @Test
        public void testUtilityLineGetType() {
            assertEquals(FIBER_OPTIC, utility.getType());
        }
    }

    @Nested
    @DisplayName("test UtilityLine setters")
    class TestUtilityLineSetters {

        @Test
        public void testUtilityLineSetName() {
            assertEquals("College Street", utility.getName());
            utility.setName("Back Lane");

            assertEquals("Back Lane", utility.getName());
        }

        @Test
        public void testUtilityLineSetUtilityType() {
            assertEquals(FIBER_OPTIC, utility.getType());
            utility.setType(UtilityType.GAS);

            assertEquals(GAS, utility.getType());
        }
    }

    @Nested
    @DisplayName("test different Utilities to JSON")
    class TestDifferentUtilitiesToJSON {

        String[] expectedJSON = new String[]{
            """
            "properties": {"type": "LINE", "label": "College Street (FIBER_OPTIC)",""" + " " +
                """
               "marker": "GREEN DOTTED", "name": "College Street", "utility": "FIBER_OPTIC"}""",
            """
            "properties": {"type": "LINE", "label": "Olympic Boulevard (WATER)",""" + " " +
                """
                "marker": "BLUE SOLID", "name": "Olympic Boulevard", "utility": "WATER"}""",
            """
            "properties": {"type": "LINE", "label": "Main Street (ELECTRICAL)",""" + " " +
                """
                "marker": "RED DASHED", "name": "Main Street", "utility": "ELECTRICAL"}"""
        };

        @Test
        public void testFiberOpticUtilityToJSON() {
            expected = expectedJSON[0];
            result = Mappable.mapIt(fiberOptic);

            assertEquals(expected, result);
        }

        @Test
        public void testWaterUtilityToJSON() {
            expected = expectedJSON[1];
            result = Mappable.mapIt(water);

            assertEquals(expected, result);
        }

        @Test
        public void testElectricalUtilityToJSON() {
            expected = expectedJSON[2];
            result = Mappable.mapIt(electrical);

            assertEquals(expected, result);
        }
    }
}
