package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RiverTest {

    private River river;
    private List<Point> renderedRiver;
    private ArrayList<Point> points;
    private Point p1, p2, p3, p4;

    @BeforeEach
    public void setUp() {
        p1 = new Point(
            new BigDecimal("47.470847"),
            new BigDecimal("-105.828641"),
            5
        );
        p2 = new Point(
            new BigDecimal("36.101589"),
            new BigDecimal("-112.089256"),
            5
        );
        p3 = new Point(
            new BigDecimal("34.296438"),
            new BigDecimal("-114.114835"),
            5
        );
        p4 = new Point(
            new BigDecimal("31.781149"),
            new BigDecimal("-114.772412"),
            5
        );

        points = new ArrayList<>(List.of(p1, p2, p3, p4));

        river = new River(points, 4, "Colorado", "River");

        renderedRiver = river.render();
    }

    @Nested
    @DisplayName("test get and set precision")
    class TestGetAndSetPrecision {

        @Test
        public void testGetRiverPrecisionField() {
            assertEquals(4, river.getPrecision());
        }

        @Test
        public void testSetRiverPrecisionField() {
            assertEquals(4, river.getPrecision());

            river.setPrecision(3);
            assertEquals(3, river.getPrecision());
        }
    }

    @Nested
    @DisplayName("test get name and type")
    class TestGetNameAndTypeOfRiver {

        @Test
        public void testGetRiverName() {
            assertEquals("Colorado", river.getName());
        }

        @Test
        public void testGetRiverType() {
            assertEquals("River", river.getType());
        }
    }

    @Nested
    @DisplayName("test river toString")
    class TestRiverToString {

        @Test
        public void testRiverToString() {
            String expected = "Colorado (River) [" +
                "[47.4709, -105.8286], " +
                "[36.1016, -112.0893], " +
                "[34.2964, -114.1148], " +
                "[31.7812, -114.7724]" +
                "]";
            String result = river.toString();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test River get points and add point to river")
    class TestGetRiverPointsAndAddPointToRiver {

        @Test
        public void testGetRiverPoints() {
            List<Point> expectedPoints = List.of(p1, p2, p3, p4);
            List<Point> resultantPoints = river.getPoints();

            assertEquals(expectedPoints, resultantPoints);
        }

        @Test
        public void testRiverAddPoint() {
            Point expectedPoint = new Point(
                new BigDecimal("45.123456"),
                new BigDecimal("56.789012"),
                5
            );
            assertEquals(4, river.getPoints().size());

            river.addPoint(expectedPoint);
            assertEquals(5, river.getPoints().size());
            assertEquals(expectedPoint, river.getPoints().getLast());
        }
    }

    @Nested
    @DisplayName("test rendered river inherits Line render mehtod")
    class TestRiverInheritsLineRenderMethod {

        @Test
        public void testRenderedRiverReturnsListOfPoints() {
            List<List<BigDecimal>> expectedPoints = List.of(
                p1.render(), p2.render(), p3.render(), p4.render());
            assertEquals(expectedPoints, renderedRiver);
        }

        @Test
        public void testRenderedRiverCanReturnAPoint() {
            assertEquals(p2.getX(), renderedRiver.get(1).getFirst());
            assertEquals(p2.getY(), renderedRiver.get(1).getLast());
        }
    }

}
