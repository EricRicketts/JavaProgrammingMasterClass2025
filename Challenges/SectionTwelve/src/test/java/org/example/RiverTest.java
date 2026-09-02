package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RiverTest {

    private River river;
    private List<List<BigDecimal>> renderedRiver;
    private ArrayList<Point> points;
    private Point p1, p2, p3, p4;

    @BeforeEach
    public void setUp() {
        p1 = new Point(
            new BigDecimal("47.470847"),
            new BigDecimal("-105.828641")
        );
        p2 = new Point(
            new BigDecimal("36.101589"),
            new BigDecimal("-112.089256")
        );
        p3 = new Point(
            new BigDecimal("34.296438"),
            new BigDecimal("-114.114835")
        );
        p4 = new Point(
            new BigDecimal("31.781149"),
            new BigDecimal("-114.772412")
        );

        points = new ArrayList<>(List.of(p1, p2, p3, p4));

        river = new River(points, 4, "Colorado", "River");

        renderedRiver = river.render();
    }

    @Nested
    @DisplayName("test get and set precision")
    class TestGetAndSetPrecision {

        @Test
        public void testGetPrecision() {
            assertEquals(4, river.getScaleFactor());
        }

        @Test
        public void testSetPrecision() {
            assertEquals(4, river.getScaleFactor());
            river.setScaleFactor(5);

            assertEquals(5, river.getScaleFactor());
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
    @DisplayName("test River get points")
    class TestGetRiverPoints {

        @Test
        public void testGetRiverPoints() {
            p1 = new Point(
                new BigDecimal("47.4709"),
                new BigDecimal("-105.8286")
            );
            p2 = new Point(
                new BigDecimal("36.1016"),
                new BigDecimal("-112.0893")
            );
            p3 = new Point(
                new BigDecimal("34.2964"),
                new BigDecimal("-114.1148")
            );
            p4 = new Point(
                new BigDecimal("31.7812"),
                new BigDecimal("-114.7724")
            );
            List<Point> expectedPoints = List.of(p1, p2, p3, p4);
            List<Point> resultantPoints = river.getPoints();

            assertEquals(expectedPoints, resultantPoints);
        }

    }

    @Nested
    @DisplayName("test rendered river inherits Line render mehtod")
    class TestRiverInheritsLineRenderMethod {

        @Test
        public void testRenderedRiverReturnsListOfPoints() {
                List<List<BigDecimal>> expectedRiverPoints = List.of(
                    List.of(
                        new BigDecimal("47.4709"),
                        new BigDecimal("-105.8286")
                    ),
                    List.of(
                        new BigDecimal("36.1016"),
                        new BigDecimal("-112.0893")
                    ),
                    List.of(
                        new BigDecimal("34.2964"),
                        new BigDecimal("-114.1148")
                    ),
                    List.of(
                        new BigDecimal("31.7812"),
                        new BigDecimal("-114.7724")
                    )
                );
            assertEquals(expectedRiverPoints, renderedRiver);
        }

        @Test
        public void testRenderedRiverCanReturnAPoint() {
        }
    }

}
