package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    private LineTwo line;

    @BeforeEach
    public void setUp() {
        line = new LineTwo(
            List.of(
                new PointTwo(
                    new BigDecimal("10.12345"),
                    new BigDecimal("-12.19284"),
                    4
                ),
                new PointTwo(
                    new BigDecimal("-23.98765"),
                    new BigDecimal("-46.12332"),
                    4
                ),
                new PointTwo(
                    new BigDecimal("-14.32457"),
                    new BigDecimal("28.38673"),
                    4
                ),
                new PointTwo(
                    new BigDecimal("53.67197"),
                    new BigDecimal("75.29103"),
                    4
                )
            ),
            4
            );
    }

    @Nested
    @DisplayName("test the scale factor on the line")
    class TestLineScaleFactor {

        @Test
        public void testScaleFactorEffectOnPoints() {
            BigDecimal[][] expected = {
                {new BigDecimal("10.1235"), new BigDecimal("-12.1928")},
                {new BigDecimal("-23.9877"), new BigDecimal("-46.1233")},
                {new BigDecimal("-14.3246"), new BigDecimal("28.3867")},
                {new BigDecimal("53.6720"), new BigDecimal("75.2910")}
            };

            for (int index = 0; index < line.render().size(); index++) {
                BigDecimal[] expectedPoint = expected[index];
                PointTwo point = line.getPoint(index);

                assertEquals(expectedPoint[0], point.getX());
                assertEquals(expectedPoint[1], point.getY());
            }
        }

        @Test
        public void testGetScaleFactor() {
            assertEquals(4, line.getScaleFactor());
        }

        @Test
        public void testSetScaleFactor() {
            assertEquals(4, line.getScaleFactor());

            line.setScaleFactor(3);
            assertEquals(3, line.getScaleFactor());
        }
    }

    @Nested
    @DisplayName("test get points of the line")
    class TestGetPointsOnTheLine {

        @Test
        public void testLineGetPoints() {
            List<PointTwo> expectedPoints = List.of(
                    new PointTwo(
                        new BigDecimal("10.12345"),
                        new BigDecimal("-12.19284"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("-23.98765"),
                        new BigDecimal("-46.12332"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("-14.32457"),
                        new BigDecimal("28.38673"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("53.67197"),
                        new BigDecimal("75.29103"),
                        4
                    )
                );
            List<PointTwo> result = line.getPoints();

            assertEquals(expectedPoints, result);
        }
    }

    @Nested
    @DisplayName("test get and set a single point from the line")
    class TestGetAndSetSinglePointFromLine {

        @Test
        public void testGetAndSetSinglePointFromLine() {
            var point = line.getPoint(1);

            assertEquals(new BigDecimal("-23.9877"), point.getX());
            assertEquals(new BigDecimal("-46.1233"), point.getY());

            line.setPoint(1,
                new BigDecimal("56.123456"),
                new BigDecimal("87.876543")
            );

            assertEquals(new BigDecimal("56.1235"), line.render().get(1).getX());
            assertEquals(new BigDecimal("87.8765"), line.render().get(1).getY());
        }


    }

    @Nested
    @DisplayName("test render the line")
    class TestRenderLine {

        @Test
        public void testRenderLine() {
            List<PointTwo> expected = new ArrayList<>(
                List.of(
                    new PointTwo(
                        new BigDecimal("10.1235"),
                        new BigDecimal("-12.1928"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("-23.9877"),
                        new BigDecimal("-46.1233"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("-14.3246"),
                        new BigDecimal("28.3867"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("53.6720"),
                        new BigDecimal("75.2910"),
                        4
                    )
                )
            );
            List<PointTwo> result = line.render();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test line Equality")
    class TestLineEquality {

        @Test
        public void testLineEquality() {
            LineTwo expectedLine = new LineTwo(
                List.of(
                    new PointTwo(
                        new BigDecimal("10.12345"),
                        new BigDecimal("-12.19284"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("-23.98765"),
                        new BigDecimal("-46.12332"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("-14.32457"),
                        new BigDecimal("28.38673"),
                        4
                    ),
                    new PointTwo(
                        new BigDecimal("53.67197"),
                        new BigDecimal("75.29103"),
                        4
                    )
                ), 4
            );

            assertEquals(expectedLine, line);
        }
    }

    @Nested
    @DisplayName("test line to string")
    class TestLineToString {

        @Test
        public void testLineToString() {
            String expected = "Line:\n" +
                "{\n" +
                "PointTwo{x=10.1235, y=-12.1928}\n" +
                "PointTwo{x=-23.9877, y=-46.1233}\n" +
                "PointTwo{x=-14.3246, y=28.3867}\n" +
                "PointTwo{x=53.6720, y=75.2910}\n" +
                "}";
            String result = line.toString();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test for defensive copying within constructor")
    class TestDefensiveConstructorCopy {

        @Test
        public void testDefensiveConstructorCopy() {
            PointTwo point1 = new PointTwo(
                new BigDecimal("12.34567"),
                new BigDecimal("98.76543"),
                4
            );
            PointTwo point2 = new PointTwo(
                new BigDecimal("13.10295"),
                new BigDecimal("48.45654"),
                4
            );
            List<PointTwo> originalPoints = new ArrayList<>(
                List.of(point1, point2)
            );
            LineTwo line = new LineTwo(originalPoints, 4);

            originalPoints.clear();

            assertEquals(2, line.getPoints().size());
        }
    }
}
