1.  Create a list of places ordered by distance from the starting point.
2.  Use a ListIterator to move forwards and backwards through this ordered itinerary of places.
3.  Create a type that has a town name and distance from your start point.  I will use a record.
4.  Then create an itinerary of places to visit the linked list will be of the record you created in step 3.
5.  The first element in the list is the closest to your starting point.
6.  Duplicates are not allowed in the list.
7.  Create a menu => (F)orward (B)ackward (L)ist places (M)enu (Q)uit

Distance from Gainesville VA
1.  Richmond: 102
2.  Charlottesville: 81
3.  Roanoke: 208
4.  Virginia Beach: 204
5.  Harrisonburg: 98
6.  Staunton: 99
7.  Culpepper: 38
8.  FredericksBurg: 48
9.  Williamsburg: 148
10. Bristol: 343

```java
package org.example;

import java.util.LinkedList;
import java.util.Objects;
import java.util.ListIterator;

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
                  .append(place.distance())
                  .append("\n");
        }

        return output.toString().stripTrailing();
    }

    public Place moveBackwards() {
        if (!iterator.hasPrevious()) {
            resetItineraryCursor();
        }
        return iterator.previous();
    }

    public Place moveForward() {
        if (!iterator.hasNext()) {
            resetItineraryCursor();
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
```