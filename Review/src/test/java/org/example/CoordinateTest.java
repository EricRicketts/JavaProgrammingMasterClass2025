package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    private Coordinate point;

    @BeforeEach
    public void setUp() {
        point = new Coordinate(8, 10);
    }

    @Nested
    @DisplayName("getters and toSting")
    class CoordinateGettersAndToString {

        @Test
        public void testGetXCoord() {
            assertEquals(
                    8,
                    point.x()
            );
        }

        @Test
        public void testGetYCoord() {
            assertEquals(
                    10,
                    point.y()
            );
        }

        @Test
        public void testToString() {
            // The toString information is so small it does not make sense to check for
            // individual pieces of data, as is done in the other toString tests.
            String expected = """
                    X coordinate = 8
                    Y coordinate = 10
                    """.trim();
            assertEquals(
                    expected,
                    point.toString()
            );
        }
    }
}
