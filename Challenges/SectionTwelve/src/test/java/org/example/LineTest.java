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

public class LineTest {

    private Line line;

    /*
        Note for the getters and the setters the original data is either
        returned without scaling or set without scaling.  It is only with
        the render method that scaling is used in the return value.
    */
    @BeforeEach
    public void setUp() {
        line = new Line(
            List.of(
                new Point(
                    new BigDecimal("10.12345"),
                    new BigDecimal("-12.19284")
                ),
                new Point(
                    new BigDecimal("-23.98765"),
                    new BigDecimal("-46.12332")
                ),
                new Point(
                    new BigDecimal("-14.32457"),
                    new BigDecimal("28.38673")
                ),
                new Point(
                    new BigDecimal("53.67197"),
                    new BigDecimal("75.29103")
                )
            ),
            4
            );
    }

    @Nested
    @DisplayName("test the scale factor on the line")
    class TestLineScaleFactor {

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
            List<Point> expectedPoints = List.of(
                    new Point(
                        new BigDecimal("10.12345"),
                        new BigDecimal("-12.19284")
                    ),
                    new Point(
                        new BigDecimal("-23.98765"),
                        new BigDecimal("-46.12332")
                    ),
                    new Point(
                        new BigDecimal("-14.32457"),
                        new BigDecimal("28.38673")
                    ),
                    new Point(
                        new BigDecimal("53.67197"),
                        new BigDecimal("75.29103")
                    )
                );
            List<Point> result = line.getPoints();

            assertEquals(expectedPoints, result);
        }
    }

    @Nested
    @DisplayName("test get and set a single point from the line")
    class TestGetAndSetSinglePointFromLine {

        @Test
        public void testGetAndSetSinglePointFromLine() {
            var point = line.getPoint(1);

            assertEquals(new Point(
                new BigDecimal("-23.98765"),
                new BigDecimal("-46.12332")
                ), point);


            line.setPoint(1,
                new BigDecimal("56.123456"),
                new BigDecimal("87.876543")
            );

            assertEquals(new Point(
                new BigDecimal("56.123456"),
                new BigDecimal("87.876543")
                ), line.getPoint(1));
        }


    }

    @Nested
    @DisplayName("test render the line")
    class TestRenderLine {

        @Test
        public void testRenderLine() {
            // It is only with render() that the scale factor is
            // taken into account on the returned data.
            List<List<BigDecimal>> expected = List.of(
                        List.of(
                            new BigDecimal("10.1235"),
                            new BigDecimal("-12.1928")
                        ),
                        List.of(
                            new BigDecimal("-23.9877"),
                            new BigDecimal("-46.1233")
                        ),
                        List.of(
                        new BigDecimal("-14.3246"),
                        new BigDecimal("28.3867")
                        ),
                        List.of(
                        new BigDecimal("53.6720"),
                        new BigDecimal("75.2910")
                        )
                );
            List<List<BigDecimal>> result = line.render();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test line Equality")
    class TestLineEquality {

        @Test
        public void testLineEquality() {
            Line expectedLine = new Line(
                List.of(
                    new Point(
                        new BigDecimal("10.12345"),
                        new BigDecimal("-12.19284")
                    ),
                    new Point(
                        new BigDecimal("-23.98765"),
                        new BigDecimal("-46.12332")
                    ),
                    new Point(
                        new BigDecimal("-14.32457"),
                        new BigDecimal("28.38673")
                    ),
                    new Point(
                        new BigDecimal("53.67197"),
                        new BigDecimal("75.29103")
                    )
                ), 4
            );

            assertEquals(expectedLine, line);
        }

        @Test
        public void testLineUnEquality() {
            Line expectedLine = new Line(
                List.of(
                    new Point(
                        new BigDecimal("10.12345"),
                        new BigDecimal("-12.19284")
                    ),
                    new Point(
                        new BigDecimal("-23.98765"),
                        new BigDecimal("-46.12332")
                    ),
                    new Point(
                        new BigDecimal("-14.32457"),
                        new BigDecimal("28.38673")
                    ),
                    new Point(
                        new BigDecimal("53.67197"),
                        new BigDecimal("75.32457") // non-matching coordinate
                    )
                ), 4
            );

            assertNotEquals(expectedLine, line);
        }
    }

    @Nested
    @DisplayName("test line to string")
    class TestLineToString {

        @Test
        public void testLineToString() {
            String expected = "Line:\n" +
                "{\n" +
                "Point{x=10.12345, y=-12.19284},\n" +
                "Point{x=-23.98765, y=-46.12332},\n" +
                "Point{x=-14.32457, y=28.38673},\n" +
                "Point{x=53.67197, y=75.29103}\n" +
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
            Point point1 = new Point(
                new BigDecimal("12.34567"),
                new BigDecimal("98.76543")
            );
            Point point2 = new Point(
                new BigDecimal("13.10295"),
                new BigDecimal("48.45654")
            );
            List<Point> originalPoints = new ArrayList<>(
                List.of(point1, point2)
            );
            Line line = new Line(originalPoints, 4);

            originalPoints.clear();

            assertEquals(2, line.getPoints().size());
        }
    }
}
