package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonAndLambdaTest {

    List<Person> people;
    Comparator<Person> comparatorLastName;

    @BeforeEach
    public void setUp() {
        people = new ArrayList<>(
            Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")
            )
        );
        comparatorLastName = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int lastNameSort = o1.lastName().compareTo(o2.lastName());
                if (lastNameSort != 0) {
                    return lastNameSort;
                } else {
                    return o1.firstName().compareTo(o2.firstName());
                }
            }
        };
    }

    @Test
    public void testSortByLastName() {
        var peopleInitialList = new ArrayList<>(
            Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")
            )
        );
        assertEquals(peopleInitialList, people);

        people.sort(comparatorLastName);
        List<Person> expectedPeopleList = new ArrayList<>(
            Arrays.asList(
                new Person("Charlie", "Brown"),
                new Person("Sally", "Brown"),
                new Person("Peppermint", "Patty"),
                new Person("Linus", "Van Pelt"),
                new Person("Lucy", "Van Pelt")
            )
        );

        assertEquals(expectedPeopleList, people);
    }

    @Test
    public void testSortByComparatorComparing() {
        var peopleInitialList = new ArrayList<>(
            Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")
            )
        );
        assertEquals(peopleInitialList, people);

        List<Person> peopleSortedList = new ArrayList<>(
            Arrays.asList(
                new Person("Charlie", "Brown"),
                new Person("Sally", "Brown"),
                new Person("Peppermint", "Patty"),
                new Person("Linus", "Van Pelt"),
                new Person("Lucy", "Van Pelt")
            )
        );
        people.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName));
        assertEquals(peopleSortedList, people);
    }
}
