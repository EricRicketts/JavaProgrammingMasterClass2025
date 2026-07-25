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
    UtilityLine utility;

    @BeforeEach
    public void setUp() {
        utilities.add(new UtilityLine("College Street", FIBER_OPTIC));
        utilities.add(new UtilityLine("Olympic Boulevard", UtilityType.WATER));
        utilities.add(new UtilityLine("Main Street", UtilityType.ELECTRICAL));
        utility = (UtilityLine) utilities.getFirst();
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
}
