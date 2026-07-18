package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FliersTest {

    private static String inFlight(FlightEnabled flier) {
        String output = flier.takeOff() + "\n" + flier.fly() + "\n";
        if (flier instanceof Trackable tracked) {
            output += tracked.track() + "\n";
        }
        output += flier.land();

        return output;
    }

    private static String triggerFliers(ArrayList<FlightEnabled> fliers) {
        String output = "";

        for (var flier : fliers) {
            output = output.concat(flier.takeOff() + "\n");
        }

        return output;
    }

    private static String flyFliers(ArrayList<FlightEnabled> fliers) {
        String output = "";

        for (var flier : fliers) {
            output = output.concat(flier.fly() + "\n");
        }

        return output;
    }

    private static String landFliers(ArrayList<FlightEnabled> fliers) {
        String output = "";

        for (var flier : fliers) {
            output = output.concat(flier.land() + "\n");
        }

        return output;
    }

    private static String betterTriggerFliers(List<FlightEnabled> fliers) {
        String output = "";

        for (var flier : fliers) {
            output = output.concat(flier.takeOff() + "\n");
        }

        return output;
    }

    private static String betterFlyFliers(List<FlightEnabled> fliers) {
        String output = "";

        for (var flier : fliers) {
            output = output.concat(flier.fly() + "\n");
        }

        return output;
    }

    private static String betterLandFliers(List<FlightEnabled> fliers) {
        String output = "";

        for (var flier : fliers) {
            output = output.concat(flier.land() + "\n");
        }

        return output;
    }

    private ArrayList<FlightEnabled> fliers = new ArrayList<>();
    private List<FlightEnabled> betterFliers = new ArrayList<>();
    private LinkedList<FlightEnabled> moreFliers = new LinkedList<>();
    private String expected, result;

    @BeforeEach
    public void setUp() {
        fliers.add(new Bird());
        fliers.add(new Eagle());

        betterFliers.add(new Bird());
        betterFliers.add(new Eagle());

        moreFliers.add(new Bird());
        moreFliers.add(new Eagle());
    }

    @Nested
    @DisplayName("test fliers")
    class TestFliers {

        @Test
        public void testTriggerFlyers() {
            expected = "Bird takes off.\nEagle takes off from its nest in the mountains.\n";
            result = triggerFliers(fliers);

            assertEquals(expected, result);
        }

        @Test
        public void testFlyFlyers() {
            expected = "Bird is flying.\nEagle does not fly it soars.\n";
            result = flyFliers(fliers);

            assertEquals(expected, result);
        }

        @Test
        public void testLandFlyers() {
            expected = "Bird is landing.\nEagle lands in its nest in the mountains.\n";
            result = landFliers(fliers);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test better fliers")
    class TestBetterFliers {

        @Test
        public void testTriggerFlyers() {
            expected = "Bird takes off.\nEagle takes off from its nest in the mountains.\n";
            result = triggerFliers((ArrayList<FlightEnabled>) betterFliers);

            assertEquals(expected, result);
        }

        @Test
        public void testFlyFlyers() {
            expected = "Bird is flying.\nEagle does not fly it soars.\n";
            result = flyFliers((ArrayList<FlightEnabled>) betterFliers);

            assertEquals(expected, result);
        }

        @Test
        public void testLandFlyers() {
            expected = "Bird is landing.\nEagle lands in its nest in the mountains.\n";
            result = landFliers((ArrayList<FlightEnabled>) betterFliers);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test better typing for the methods, fliers List Argument")
    class TestBetterTypingForMethodsFliersListArgument {

        @Test
        public void testImprovedTriggerFlyersMethodListArgument() {
            expected = "Bird takes off.\nEagle takes off from its nest in the mountains.\n";
            result = betterTriggerFliers(fliers);

            assertEquals(expected, result);
        }

        @Test
        public void testImprovedFlyFlyersMethodListArgument() {
            expected = "Bird is flying.\nEagle does not fly it soars.\n";
            result = betterFlyFliers(fliers);

            assertEquals(expected, result);
        }

        @Test
        public void testImprovedLandFlyersMethodListArgument() {
            expected = "Bird is landing.\nEagle lands in its nest in the mountains.\n";
            result = betterLandFliers(fliers);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test better typing for the methods, better fliers List Argument")
    class TestBetterTypingForMethodsBetterFliersListArgument {

        @Test
        public void testImprovedTriggerBetterFlyerMethodListArgument() {
            expected = "Bird takes off.\nEagle takes off from its nest in the mountains.\n";
            result = betterTriggerFliers(betterFliers);

            assertEquals(expected, result);
        }

        @Test
        public void testImprovedFlyBetterFlyerMethodListArgument() {
            expected = "Bird is flying.\nEagle does not fly it soars.\n";
            result = betterFlyFliers(betterFliers);

            assertEquals(expected, result);
        }

        @Test
        public void testImprovedLandBetterFlyerMethodListArgument() {
            expected = "Bird is landing.\nEagle lands in its nest in the mountains.\n";
            result = betterLandFliers(betterFliers);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test better typing for the methods, more fliers List Argument")
    class TestBetterTypingForMethodsMoreFliersListArgument {

        @Test
        public void testImprovedTriggerMoreFlyersMethodListArgument() {
            expected = "Bird takes off.\nEagle takes off from its nest in the mountains.\n";
            result = betterTriggerFliers(moreFliers);

            assertEquals(expected, result);
        }

        @Test
        public void testImprovedFlyMoreFlyersMethodListArgument() {
            expected = "Bird is flying.\nEagle does not fly it soars.\n";
            result = betterFlyFliers(moreFliers);

            assertEquals(expected, result);
        }

        @Test
        public void testImprovedLandMoreFlyersMethodListArgument() {
            expected = "Bird is landing.\nEagle lands in its nest in the mountains.\n";
            result = betterLandFliers(moreFliers);

            assertEquals(expected, result);
        }
    }
}
