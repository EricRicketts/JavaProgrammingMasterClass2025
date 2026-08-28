package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTwoTest {

    private LineTwo line;

    @BeforeEach
    public void setUp() {
        line = new LineTwo(
            List.of(
                new PointTwo(
                    new BigDecimal("10.12345"),
                    new BigDecimal("-12.19284")
                ),
                new PointTwo(
                    new BigDecimal("-23.98765"),
                    new BigDecimal("-46.12332")
                ),
                new PointTwo(
                    new BigDecimal("-14.32457"),
                    new BigDecimal("28.38673")
                ),
                new PointTwo(
                    new BigDecimal("53.67197"),
                    new BigDecimal("75.29103")
                )
            ), 4
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
                PointTwo point = line.render().get(index);

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
}
