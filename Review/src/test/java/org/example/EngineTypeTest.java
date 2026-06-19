package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTypeTest {

    EngineType engineTypeInlineFour, engineTypeInlineSix;

    @Nested
    @DisplayName("test inline engine types")
    class TestInlineEngineType {

        @BeforeEach
        public void setUp() {
            engineTypeInlineFour = EngineType.INLINE_FOUR;
            engineTypeInlineSix = EngineType.INLINE_SIX;
        }

        @Test
        public void testInlineFourEngineTypeNumberOfCylinders() {
            assertEquals(4, engineTypeInlineFour.getNumberOfCylinders());
        }

        @Test
        public void testInlineFourEngineTypeCylinderArrangement() {
            assertEquals("Inline", engineTypeInlineFour.getCylinderArrangement());
        }

        @Test
        public void testInlineSixEngineTypeNumberOfCylinders() {
            assertEquals(6, engineTypeInlineSix.getNumberOfCylinders());
        }

        @Test
        public void testInlineSixEngineTypeCylinderArrangement() {
            assertEquals("Inline", engineTypeInlineSix.getCylinderArrangement());
        }
    }
}
