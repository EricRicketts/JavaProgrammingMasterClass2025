package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineTypeTest {

    EngineType engineTypeInlineFour, engineTypeInlineSix;

    EngineType engineTypeVSix, engineTypeVEight, engineTypeVTwelve;

    EngineType engineTypeFlatTen;

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

    @Nested
    @DisplayName("test V engine types")
    class TestVEngineTypes {

        @BeforeEach
        public void setUp() {
            engineTypeVSix = EngineType.V_SIX;
            engineTypeVEight = EngineType.V_EIGHT;
            engineTypeVTwelve = EngineType.V_TWELVE;
        }

        @Test
        public void testVSixEngineTypeNumberOfCylinders() {
            assertEquals(6, engineTypeVSix.getNumberOfCylinders());
        }

        @Test
        public void testVSixEngineTypeCylinderArrangement() {
            assertEquals("V", engineTypeVSix.getCylinderArrangement());
        }

        @Test
        public void testVEightEngineTypeNumberOfCylinders() {
            assertEquals(8, engineTypeVEight.getNumberOfCylinders());
        }

        @Test
        public void testVEightEngineTypeCylinderArrangement() {
            assertEquals("V", engineTypeVEight.getCylinderArrangement());
        }

        @Test
        public void testVTwelveEngineTypeNumberOfCylinders() {
            assertEquals(12, engineTypeVTwelve.getNumberOfCylinders());
        }

        @Test
        public void testVTwelveEngineTypeCylinderArrangement() {
            assertEquals("V", engineTypeVTwelve.getCylinderArrangement());
        }
    }

    @Nested
    @DisplayName("test flat engine type")
    class TestFlatEngineType {

        @BeforeEach
        public void setUp() {
            engineTypeFlatTen = EngineType.FLAT_TEN;
        }

        @Test
        public void testVFlatTenEngineTypeNumberOfCylinders() {
            assertEquals(10, engineTypeFlatTen.getNumberOfCylinders());
        }

        @Test
        public void testFlatTenEngineTypeCylinderArrangement() {
            assertEquals("Flat", engineTypeFlatTen.getCylinderArrangement());
        }
    }
}
