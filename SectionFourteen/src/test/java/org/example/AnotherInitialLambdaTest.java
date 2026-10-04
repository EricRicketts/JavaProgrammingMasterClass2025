package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnotherInitialLambdaTest {

    private List<Person> people, sortedPeople;

    @BeforeEach
    public void setUp() {
        people = new ArrayList<>(
            List.of(
                new Person("Bugs", "Bunny"),
                new Person("Porky", "Pig"),
                new Person("Foghorn", "Leghorn"),
                new Person("Daffy", "Duck"),
                new Person("Elmer", "Fudd")
            )
        );
        sortedPeople = new ArrayList<>(
            List.of(
                new Person("Bugs", "Bunny"),
                new Person("Daffy", "Duck"),
                new Person("Elmer", "Fudd"),
                new Person("Foghorn", "Leghorn"),
                new Person("Porky", "Pig")
            )
        );
    }

    @Nested
    @DisplayName("test sorting with an anonymous class")
    class TestSortWithAnonymousClass {

        @Test
        public void sortWithAnonymousClass() {
            var comparator = new Comparator<Person>() {

                @Override
                public int compare(Person p1, Person p2) {
                    int compareLastNames = p1.lastName().compareTo(p2.lastName());
                    int compareFirstNames = p1.firstName().compareTo(p2.firstName());

                    return (compareLastNames != 0) ? compareLastNames : compareFirstNames;
                }
            };

            people.sort(comparator);

            assertEquals(sortedPeople, people);
        }
    }
}
