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

    private Layer<Park> parkLayer;
    private Layer<River> riverLayer;
    private Point p1, p2, p3, p4, p5, p6, p7, p8, p9;

    @BeforeEach
    public void setUp() {
        // Points p1 through p4 designate the Colorado River.
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

        ArrayList<Point> coloradoRiverPoints = new ArrayList<>(List.of(p1, p2, p3, p4));
        River coloradoRiver = new River(coloradoRiverPoints, 4, "Colorado", "River");

        // Points p5 through p7 designate the Mississippi River.
        p5 = new Point(
            new BigDecimal("47.216067"),
            new BigDecimal("-95.234834")
        );
        p6 = new Point(
            new BigDecimal("35.115623"),
            new BigDecimal("-90.065988")
        );
        p7 = new Point(
            new BigDecimal("29.156612"),
            new BigDecimal("-89.249556")
        );

        ArrayList<Point> mississippiRiverPoints = new ArrayList<>(List.of(p5, p6, p7));
        River mississippiRiver = new River(mississippiRiverPoints, 4, "Mississippi", "River");

        riverLayer = new Layer<River>(new ArrayList<>(List.of(coloradoRiver, mississippiRiver)));

        // Point p8 is for Yellowstone National Park.
        p8 = new Point(
            new BigDecimal("44.488214"),
            new BigDecimal("-110.591636")
        );

        // Point p9 is for Yosemite National Park.
        p9 = new Point(
            new BigDecimal("37.885555"),
            new BigDecimal("-119.536054")
        );

        Park yellowstone = new Park("Yellowstone", "National Park", p8.getX(), p8.getY(), 4);
        Park yosemite = new Park("Yosemite", "National Park", p9.getX(), p9.getY(), 4);

        parkLayer = new Layer<Park>(new ArrayList<>(List.of(yellowstone, yosemite)));
    }

    @Nested
    @DisplayName("test first river Layer")
    class TestFirstRiverLayer {

        @Test
        public void testFirstRiverOfRiverLayerGetNameAndType() {
            River coloradoRiver = riverLayer.getListOfElements().getFirst();

            assertEquals("Colorado", coloradoRiver.getName());
            assertEquals("River", coloradoRiver.getType());
        }

        @Test
        public void testFirstRiverLayerGetNumberOfPoints() {
            River coloradoRiver = riverLayer.getListOfElements().getFirst();

            assertEquals(4, coloradoRiver.getPoints().size());
        }

        @Test
        public void testRenderFirstRiver() {
            River coloradoRiver = riverLayer.getListOfElements().getFirst();
            List<List<BigDecimal>> coloradoRiverCoordinates = coloradoRiver.render();
            List<List<Point>> expectedColoradoRiverCoordinates = new ArrayList<>();

            List<Point> p1Coordinates = new ArrayList<>(
                List.of(new Point(
                    new BigDecimal("47.4709"),
                    new BigDecimal("-105.8286")
                    )
                )
            );
            expectedColoradoRiverCoordinates.add(p1Coordinates);

            List<Point> p2Coordinates = new ArrayList<>(
                List.of(
                    new Point(
                        new BigDecimal("36.1016"),
                        new BigDecimal("-112.0893")
             )
                )
            );
            expectedColoradoRiverCoordinates.add(p2Coordinates);

            List<Point> p3Coordinates = new ArrayList<>(
                List.of(
                    new Point(
                        new BigDecimal("34.2964"),
                        new BigDecimal("-114.1148")
             )
                )
            );
            expectedColoradoRiverCoordinates.add(p3Coordinates);

            List<Point> p4Coordinates = new ArrayList<>(
                List.of(
                    new Point(
                        new BigDecimal("31.7812"),
                        new BigDecimal("-114.7724")
              )
                )
            );
            expectedColoradoRiverCoordinates.add(p4Coordinates);

            assertEquals(expectedColoradoRiverCoordinates, coloradoRiverCoordinates);
        }
    }

    @Nested
    @DisplayName("test second river Layer")
    class TestSecondRiverLayer {

        @Test
        public void testSecondRiverOfRiverLayerGetNameAndType() {
            River mississippiRiver = riverLayer.getListOfElements().getLast();

            assertEquals("Mississippi", mississippiRiver.getName());
            assertEquals("River", mississippiRiver.getType());
        }

        @Test
        public void testSecondRiverLayerGetNumberOfPoints() {
            River mississippiRiver = riverLayer.getListOfElements().getLast();

            assertEquals(3, mississippiRiver.getPoints().size());
        }

        @Test
        public void testRenderSecondRiver() {
            River mississippiRiver = riverLayer.getListOfElements().getLast();
            List<List<BigDecimal>> mississippiRiverCoordinates = mississippiRiver.render();
            List<List<BigDecimal>> expectedMississippiRiverCoordinates = new ArrayList<>();

            List<BigDecimal> p1Coordinates = new ArrayList<>(
                List.of(new BigDecimal("47.2161"), new BigDecimal("-95.2348"))
            );
            expectedMississippiRiverCoordinates.add(p1Coordinates);

            List<BigDecimal> p2Coordinates = new ArrayList<>(
                List.of(new BigDecimal("35.1156"), new BigDecimal("-90.0660"))
            );
            expectedMississippiRiverCoordinates.add(p2Coordinates);

            List<BigDecimal> p3Coordinates = new ArrayList<>(
                List.of(new BigDecimal("29.1566"), new BigDecimal("-89.2496"))
            );
            expectedMississippiRiverCoordinates.add(p3Coordinates);

            assertEquals(expectedMississippiRiverCoordinates, mississippiRiverCoordinates);
        }
    }

    @Nested
    @DisplayName("test render the two parks")
    class TestGetNameAndTypeOfParksAndRenderParkLayers {

        @Test
        public void testGetFirstParkNameAndType() {
            assertEquals("Yellowstone", parkLayer.getListOfElements().getFirst().getName());
            assertEquals("National Park", parkLayer.getListOfElements().getFirst().getType());
        }

        @Test
        public void testGetSecondParkNameAndType() {
            assertEquals("Yosemite", parkLayer.getListOfElements().getLast().getName());
            assertEquals("National Park", parkLayer.getListOfElements().getLast().getType());
        }

        @Test
        public void testRenderFirstPark() {
            Park yellowstoneNationalPark = parkLayer.getListOfElements().getFirst();
            List<BigDecimal> yellowstoneNationalParkCoordinates = yellowstoneNationalPark.render();

            List<BigDecimal> expectedYellowstoneNationalParkCoordinates =
                new ArrayList<>(List.of(
                    new BigDecimal("44.4882"),
                    new BigDecimal("-110.5916")
                    )
                );

            assertEquals(expectedYellowstoneNationalParkCoordinates, yellowstoneNationalParkCoordinates);
        }

        @Test
        public void testRenderSecondPark() {
            Park yosemiteNationalPark = parkLayer.getListOfElements().getLast();
            List<BigDecimal> yosemiteNationalParkCoordinates = yosemiteNationalPark.render();

            List<BigDecimal> expectedYosemiteNationalParkCoordinates =
                new ArrayList<>(List.of(
                    new BigDecimal("37.8856"),
                    new BigDecimal("-119.5361")
                    )
                );

            assertEquals(expectedYosemiteNationalParkCoordinates, yosemiteNationalParkCoordinates);
        }
    }

    @Nested
    @DisplayName("test river layers toString")
    class TestRiverLayersToString {

        @Test
        public void testFirstRiverLayerToString() {
            River coloradoRiver = riverLayer.getListOfElements().getFirst();
            String coloradoRiverString = coloradoRiver.toString();

            String expectedColoradoRiverString = "Colorado (River) [" +
                "[47.4709, -105.8286], " +
                "[36.1016, -112.0893], " +
                "[34.2964, -114.1148], " +
                "[31.7812, -114.7724]" +
                "]";

                assertEquals(expectedColoradoRiverString, coloradoRiverString);
        }

        @Test
        public void testSecondRiverLayerToString() {
            River mississippiRiver = riverLayer.getListOfElements().getLast();
            String mississippiRiverString = mississippiRiver.toString();

            String expectedMississippiRiverString = "Mississippi (River) [" +
                "[47.2161, -95.2348], " +
                "[35.1156, -90.0660], " +
                "[29.1566, -89.2496]" +
                "]";

            assertEquals(expectedMississippiRiverString, mississippiRiverString);
        }
    }

    @Nested
    @DisplayName("test park layers toString")
    class TestParkLayersToString {

        @Test
        public void testFirstParkLayerToString() {
            Park yellowstoneNationalPark = parkLayer.getListOfElements().getFirst();
            String yellowstoneNationalParkString = yellowstoneNationalPark.toString();

            String expectedYellowstoneNationalParkString = "Yellowstone (National Park) " +
                "[44.4882, -110.5916]";

            assertEquals(expectedYellowstoneNationalParkString, yellowstoneNationalParkString);
        }

        @Test
        public void testSecondParkLayerToString() {
            Park yosemiteNationalPark = parkLayer.getListOfElements().getLast();
            String yosemiteNationalParkString = yosemiteNationalPark.toString();

            String expectedYosemiteNationalParkString = "Yosemite (National Park) " +
                "[37.8856, -119.5361]";

            assertEquals(expectedYosemiteNationalParkString, yosemiteNationalParkString);
        }
    }
}
