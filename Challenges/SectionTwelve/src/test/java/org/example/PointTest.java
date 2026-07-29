package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    private Point point;

    @BeforeEach
    public void setUp() {
        BigDecimal x = new BigDecimal("11.34568");
        BigDecimal y = new BigDecimal("13.09876");
        point = new Point(x, y, 4);
    }

    @Nested
    @DisplayName("test getters and setters for Point")
    class TestGettersAndSettersForPoint {

        @Test
        public void testGetPointXCoord() {
            BigDecimal expected = new BigDecimal("11.3457");
            BigDecimal result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testGetPointYCoord() {
            BigDecimal expected = new BigDecimal("13.0988");
            BigDecimal result = point.getY();

            assertEquals(expected, result);
        }

        @Test
        public void testSetPointXCoord() {
            BigDecimal expected = new BigDecimal("11.3457");
            BigDecimal result = point.getX();

            assertEquals(expected, result);

            point.setX(new BigDecimal("23.123"));
            expected = new BigDecimal("23.1230");
            result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testSetPointYCoord() {
            BigDecimal expected = new BigDecimal("13.0988");
            BigDecimal result = point.getY();

            assertEquals(expected, result);

            point.setY(new BigDecimal("31.112"));
            expected = new BigDecimal("31.1120");
            result = point.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test render point and point toString")
    class TestRenderPointAndPointToString {

        @Test
        public void testRenderPoint() {
            List<BigDecimal> expectedPoint = new ArrayList<>(
                List.of(
                new BigDecimal("11.3457"),
                new BigDecimal("13.0988")
                )
            );
            List<BigDecimal> resultantPoint = point.render();

            assertEquals(expectedPoint, resultantPoint);
        }

        @Test
        public void testPointToString() {
            String expected = "[11.3457, 13.0988]";
            String result = point.toString();

            assertEquals(expected, result);
        }
    }
}
