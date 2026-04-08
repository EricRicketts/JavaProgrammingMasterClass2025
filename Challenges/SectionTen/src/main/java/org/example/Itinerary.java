package org.example;

import java.util.*;

public class Itinerary {

    private final LinkedList<Place> listOfPlaces = new LinkedList<>();
    private ListIterator<Place> iterator = listOfPlaces.listIterator();

    public Itinerary(LinkedList<Place> route) {
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

    public Place moveBackwards() {
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
       System.exit(0);
    }

    public String showMenu() {
        return """
               (F)orward
               (B)ackward
               (L)ist places
               (M)enu
               (Q)uit""";
    }

    private void resetItineraryCursor() {
        iterator = listOfPlaces.listIterator();
    }
}
