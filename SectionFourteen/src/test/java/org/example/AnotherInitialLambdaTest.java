package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AnotherInitialLambdaTest {

    private List<Person> people, sortedPeople, copyOfPeople;

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
        copyOfPeople = new ArrayList<>(people);
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
            assertEquals(people, copyOfPeople);

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
            assertNotEquals(sortedPeople, copyOfPeople);
        }
    }

    @Nested
    @DisplayName("test sort with lambda expression")
    class TestSortWithLambdaExpression {

        @Test
        public void testSortWithLambdaExpression() {
            assertEquals(people, copyOfPeople);
            people.sort(
                (o1, o2) -> {
                    int compareLastNames = o1.lastName().compareTo(o2.lastName());
                    int compareFirstNames = o1.firstName().compareTo(o2.firstName());
                    return (compareLastNames != 0) ? compareLastNames : compareFirstNames;
                }
            );

            assertEquals(sortedPeople, people);
            assertNotEquals(sortedPeople, copyOfPeople);
        }
    }

    @Nested
    @DisplayName("sort with Enhanced Comparator")
    class TestSortWithEnhancedComparator {

        @Test
        public void testWithEnhancedComparator() {
            // As of JDK16 local interfaces can be declared in a method block.
            // In this case the test method block serves as the method block.
            interface EnhancedComparator<T> extends Comparator<T> {
                int secondLevel(T o1, T o2);
            }

            var comparatorEnhanced = new EnhancedComparator<Person>() {

                @Override
                public int secondLevel(Person o1, Person o2) {
                    return o1.firstName().compareTo(o2.firstName());
                }

                @Override
                public int compare(Person o1, Person o2) {
                    int result = o1.lastName().compareTo(o2.lastName());
                    return (result == 0)
                        ? secondLevel(o1, o2) : result;
                }
            };
            assertEquals(copyOfPeople, people);
            people.sort(comparatorEnhanced);
            assertEquals(sortedPeople, people);
            assertNotEquals(sortedPeople, copyOfPeople);
        }
    }
}
