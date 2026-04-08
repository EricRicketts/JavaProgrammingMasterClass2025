package org.example;

import java.util.*;

public class Itinerary {

    private final LinkedList<Place> listOfPlaces = new LinkedList<>();
    private ListIterator<Place> iterator = listOfPlaces.listIterator();
    private final Runnable exitAction;

    public Itinerary(LinkedList<Place> route) {
        this(route, () -> System.exit(0));
    }

    public Itinerary(LinkedList<Place> route, Runnable exitAction) {
        this.exitAction = exitAction;
        for (Place place : route) {
            if (Objects.nonNull(place) && !listOfPlaces.contains(place)) {
                listOfPlaces.add(place);
            }
        }
        resetItineraryCursor();
    }

    public String listPlaces() {
        resetItineraryCursor();
        StringBuilder output = new StringBuilder();
        while (iterator.hasNext()) {
            Place place = iterator.next();
            output.append("name = ")
                  .append(place.name())
                  .append(", ")
                  .append("distance = ")
                  .append(String.valueOf(place.distance()))
                  .append("\n");
        }
        return output.toString().stripTrailing();
    }

    public Place moveBackward() {
        if (!iterator.hasPrevious()) {
            this.resetItineraryCursor();
        }
        return iterator.previous();
    }

    public Place moveForward() {
        if (!iterator.hasNext()) {
            this.resetItineraryCursor();
        }
        return iterator.next();
    }

    public void quit() {
        exitAction.run();
    }

    public String showMenu() {
        return """
               (F)orward
               (B)ackward
               (L)ist places
               (M)enu
               (Q)uit""";
    }

    public void resetItineraryCursor() {
        iterator = listOfPlaces.listIterator();
    }
}
