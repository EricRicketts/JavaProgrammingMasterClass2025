package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTwoTest {

    private PointTwo point;
    private BigDecimal expected, result;

    @BeforeEach
    public void setUp() {
        point = new PointTwo(
            new BigDecimal("23.45675"),
            new BigDecimal("45.67894"),
            4
        );
    }

    @Nested
    @DisplayName("test point two getters")
    class TestPointTwoGetters {

        @Test
        public void testXGetter() {
            expected = new BigDecimal("23.4568");
            result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testYGetter() {
            expected = new BigDecimal("45.6789");
            result = point.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test point two setters")
    class TestPointTwoSetters {

        @Test
        public void testXSetter() {
            expected = new BigDecimal("23.4568");
            result = point.getX();

            assertEquals(expected, result);

            point.setX(new BigDecimal("12.34567"));
            expected = new BigDecimal("12.3457");
            result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testYSetter() {
            expected = new BigDecimal("45.6789");
            result = point.getY();

            assertEquals(expected, result);

            point.setY(new BigDecimal("34.56783"));
            expected = new BigDecimal("34.5678");
            result = point.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test scale factor for point two")
    class TestScaleFactorForPointTwo {

        @Test
        public void testThreeDigitScaleFactor() {
            assertEquals(4, point.getScaleFactor());
            point.setScaleFactor(3);

            expected = new BigDecimal("23.457");
            result = point.getX();

            assertEquals(expected, result);
        }

        @Test
        public void testSixDigitScaleFactor() {
            assertEquals(4, point.getScaleFactor());
            point.setScaleFactor(6);

            expected = new BigDecimal("45.678940");
            result = point.getY();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test point render method")
    class TestPointTwoRenderMethod {

        @Test
        public void testPointTwoRenderMethod() {
            List<BigDecimal> expected = new ArrayList<>(
                List.of(
                    new BigDecimal("23.4568"),
                    new BigDecimal("45.6789")
                )
            );
            List<BigDecimal> result = point.render();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test point two equal method")
    class TestPointTwoEqualMethod {

        @Test
        public void testPointTwoEqualsMethod() {
            PointTwo expected = new PointTwo(
                new BigDecimal("23.45675"),
                new BigDecimal("45.67894"),
                4
            );
            assertEquals(expected, point);
        }

        @Test
        public void testEqualsPointsHaveSameHashCode() {
            PointTwo samePoint = new PointTwo(
                new BigDecimal("23.45675"),
                new BigDecimal("45.67894"),
                4
            );

            assertEquals(point, samePoint);
            assertEquals(point.hashCode(), samePoint.hashCode());
        }
    }

    @Nested
    @DisplayName("test point two to string")
    class TestPointTwoToString {

        @Test
        public void testPointTwoToString() {
            String expected = "PointTwo{x=23.4568, y=45.6789}";
            String result = point.toString();
            
            assertEquals(expected, result);
        }
    }
}
