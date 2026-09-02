package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PointTest {

    private Point point;
    private BigDecimal expected, result;

    @BeforeEach
    public void setUp() {
        point = new Point(
            new BigDecimal("23.45675"),
            new BigDecimal("45.67894")
        );
    }

    @Nested
    @DisplayName("test point two getters")
    class TestPointTwoGetters {

        @Test
        public void testXGetter() {
            expected = new BigDecimal("23.45675");
            result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testYGetter() {
            expected = new BigDecimal("45.67894");
            result = point.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test point two setters")
    class TestPointTwoSetters {

        @Test
        public void testXSetter() {
            expected = new BigDecimal("23.45675");
            result = point.getX();

            assertEquals(expected, result);

            point.setX(new BigDecimal("12.34567"));
            expected = new BigDecimal("12.34567");
            result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testYSetter() {
            expected = new BigDecimal("45.67894");
            result = point.getY();

            assertEquals(expected, result);

            point.setY(new BigDecimal("34.56783"));
            expected = new BigDecimal("34.56783");
            result = point.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test point render method")
    class TestPointTwoRenderMethod {

        @Test
        public void testPointRenderMethod() {
            List<BigDecimal> expected = new ArrayList<>(
                List.of(
                    new BigDecimal("23.45675"),
                    new BigDecimal("45.67894")
                )
            );
            List<BigDecimal> result = point.render();

            assertEquals(expected, result);
        }

        @Test
        public void testRenderReturnsIndependentList() {
            List<BigDecimal> renderedPoint = point.render();

            renderedPoint.set(0, new BigDecimal("47.47381"));

            assertEquals(new BigDecimal("23.45675"), point.getX());
            assertEquals(new BigDecimal("45.67894"), point.getY());
        }
    }

    @Nested
    @DisplayName("test point two equal method")
    class TestPointTwoEqualMethod {

        @Test
        public void testPointEqualsMethod() {
            Point expected = new Point(
                new BigDecimal("23.45675"),
                new BigDecimal("45.67894")
            );
            assertEquals(expected, point);
        }

        @Test
        public void testEqualPointsHaveSameHashCode() {
            Point samePoint = new Point(
                new BigDecimal("23.45675"),
                new BigDecimal("45.67894")
            );

            assertEquals(point, samePoint);
            assertEquals(point.hashCode(), samePoint.hashCode());
        }

        @Test
        public void testUnequalPointsAreNotEqual() {
            Point differentPoint = new Point(
                new BigDecimal("45.77558"),
                new BigDecimal("54.11223")
            );

            assertNotEquals(point, differentPoint);
        }
    }

    @Nested
    @DisplayName("test point two to string")
    class TestPointTwoToString {

        @Test
        public void testPointToString() {
            String expected = "Point{x=23.45675, y=45.67894}";
            String result = point.toString();
            
            assertEquals(expected, result);
        }
    }
}
