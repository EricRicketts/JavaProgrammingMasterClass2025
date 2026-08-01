package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LayerTest {

    private Layer<Park> pointLayer;
    private Layer<River> riverLayer;
    private Point p1, p2, p3, p4, p5, p6, p7, p8, p9;

    @BeforeEach
    public void setUp() {
        // Points p1 through p4 designate the Colorado River.
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

        ArrayList<Point> coloradoRiverPoints = new ArrayList<>(List.of(p1, p2, p3, p4));
        River coloradoRiver = new River(coloradoRiverPoints, 4, "Colorado", "River");

        // Points p5 through p7 designate the Mississippi River.
        p5 = new Point(
            new BigDecimal("47.216067"),
            new BigDecimal("-95.234834"),
            5
        );
        p6 = new Point(
            new BigDecimal("35.115623"),
            new BigDecimal("-90.065988"),
            5
        );
        p7 = new Point(
            new BigDecimal("29.156612"),
            new BigDecimal("-89.249556"),
            5
        );

        ArrayList<Point> mississippiRiverPoints = new ArrayList<>(List.of(p5, p6, p7));
        River mississippiRiver = new River(mississippiRiverPoints, 4, "Mississippi", "River");

        riverLayer = new Layer<River>(new ArrayList<>(List.of(coloradoRiver, mississippiRiver)));

        // Point p8 is for Yellowstone National Park.
        p8 = new Point(
            new BigDecimal("44.488214"),
            new BigDecimal("-110.591636"),
            5
        );

        // Point p9 is for Yosemite National Park.
        p9 = new Point(
            new BigDecimal("37.885555"),
            new BigDecimal("-119.536054"),
            5
        );

        Park yellowstone = new Park("Yellowstone", "National Park", p8.getX(), p8.getY(), 4);
        Park yosemite = new Park("Yosemite", "National Park", p9.getX(), p9.getY(), 4);

        pointLayer = new Layer<Park>(new ArrayList<>(List.of(yellowstone, yosemite)));
    }

    @Nested
    @DisplayName("test first river Layer")
    class TestFirstRiverLayer {

        @Test
        public void testFirstRiverOfRiverLayerGetNameAndType() {
            River coloradoRiver = riverLayer.getListOfElements().getFirst();

            assertEquals("Colorado", coloradoRiver.getName());
            assertEquals("Type", coloradoRiver.getType());
        }

        @Test
        public void testFirstRiverLayerGetFirstPoint() {
            River coloradoRiver = riverLayer.getListOfElements().getFirst();

            assertEquals(4, coloradoRiver.getPoints().size());
        }
    }
}
