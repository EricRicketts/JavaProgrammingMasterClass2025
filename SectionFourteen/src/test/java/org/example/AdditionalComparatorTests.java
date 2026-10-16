package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionalComparatorTests {

    List<Person> expected;
    List<Person> list = new ArrayList<>(List.of(
        new Person("Peter", "Pan"),
        new Person("Peter", "PumpkinEater"),
        new Person("Minnie", "Mouse"),
        new Person("Mickey", "Mouse")
    ));

    @Nested
    @DisplayName("test various comparator methods")
    class TestVariousComparatorMethods {

        @Test
        public void testSortLastNameWithALambda() {
            expected = new ArrayList<>(List.of(
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse"),
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater")
                ));
            list.sort((p1, p2) -> p1.lastName().compareTo(p2.lastName()));
            assertEquals(expected, list);
        }

        @Test
        public void testSortWithComparatorComparing() {
            expected = new ArrayList<>(List.of(
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse"),
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater")
            ));
            list.sort(Comparator.comparing(Person::lastName));
            assertEquals(expected, list);
        }

        @Test
        public void testSortWithComparatorComparingLastAndFirstNames() {
            expected = new ArrayList<>(List.of(
                new Person("Mickey", "Mouse"),
                new Person("Minnie", "Mouse"),
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater")
            ));
            list.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName));
            assertEquals(expected, list);
        }

        @Test
        public void testSortWithComparatorComparingLastAndFirstNamesThenReversing() {
            expected = new ArrayList<>(List.of(
                new Person("Peter", "PumpkinEater"),
                new Person("Peter", "Pan"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
            ));
            list.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName).reversed());
            assertEquals(expected, list);
        }
    }
}
