package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTwoTest {

    private PointTwo pointTwo;
    private BigDecimal expected, result;

    @BeforeEach
    public void setUp() {
        pointTwo = new PointTwo(
            new BigDecimal("23.45675"),
            new BigDecimal("45.67894"));
    }

    @Nested
    @DisplayName("test point two getters")
    class TestPointTwoGetters {

        @Test
        public void testXGetter() {
            expected = new BigDecimal("23.4568");
            result = pointTwo.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testYGetter() {
            expected = new BigDecimal("45.6789");
            result = pointTwo.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test point two setters")
    class TestPointTwoSetters {

        @Test
        public void testXSetter() {
            expected = new BigDecimal("23.4568");
            result = pointTwo.getX();

            assertEquals(expected, result);

            pointTwo.setX(new BigDecimal("12.34567"));
            expected = new BigDecimal("12.3457");
            result = pointTwo.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testYSetter() {
            expected = new BigDecimal("45.6789");
            result = pointTwo.getY();

            assertEquals(expected, result);

            pointTwo.setY(new BigDecimal("34.56783"));
            expected = new BigDecimal("34.5678");
            result = pointTwo.getY();

            assertEquals(expected, result);
        }
    }
}
