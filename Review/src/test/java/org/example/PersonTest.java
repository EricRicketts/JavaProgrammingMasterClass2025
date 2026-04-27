package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person firstPerson;
    private Person secondPerson;

    @BeforeEach
    public void setUp() {
        firstPerson = new Person("Elmer Fudd", 43, "Hollywood");
        secondPerson = new Person("John Doe", 50);
    }

    @Nested
    @DisplayName("Test three argument constructor checks")
    class ThreeArgumentConstructorChecks {

        @Test
        public void testConstructorRejectsNullName() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person(null, 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsEmptyName() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankName() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person(" ", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNullCity() {
            assertEquals(
                    "Null value is not allowed for city",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person("Elmer Fudd", 43, null)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsEmptyCity() {
            assertEquals(
                    "Blank or empty value is not allowed for city",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 43, "")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankCity() {
            assertEquals(
                    "Blank or empty value is not allowed for city",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 43, " ")
                    ).getMessage()
            );
        }
        @Test
        public void testConstructorRejectsNegativeAge() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                           IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", -1, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsZeroAge() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 0, "Hollywood")
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Test two argument constructor checks")
    class TwoArgumentConstructorChecks {

        @Test
        public void testConstructorRejectsNullName() {
            assertEquals(
                    "Null value is not allowed for name",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person(null, 12)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsEmptyName() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankName() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person(" ", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNegativeAge() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", -4)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsZeroAge() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 0)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("Getter tests for three argument constructor")
    class GetterChecksForThreeArgumentConstructor {

        @Test
        public void testGetPersonName() {
            assertEquals("Elmer Fudd", firstPerson.getName());
        }

        @Test
        public void testGetPersonAge() {
            assertEquals(43, firstPerson.getAge());
        }

        @Test
        public void testGetPersonCity() {
            assertEquals("Hollywood", firstPerson.getCity());
        }
    }

    @Nested
    @DisplayName("Getter tests for two argument constructor")
    class GetterChecksForTwoArgumentConstructor {

        @Test
        public void testGetPersonName() {
            assertEquals("John Doe", secondPerson.getName());
        }

        @Test
        public void testGetPersonAge() {
            assertEquals(50, secondPerson.getAge());
        }

        @Test
        public void testGetPersonCity() {
            assertEquals("Unknown", secondPerson.getCity());
        }
    }

    @Nested
    @DisplayName("Setter tests for age")
    class SetterChecksForAge {

        @Test
        public void testSetterRejectsNegativeAge() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> firstPerson.setAge(-12)
                    ).getMessage()
            );
        }

        @Test
        public void testSetterRejectsZeroAge() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> firstPerson.setAge(0)
                    ).getMessage()
            );
        }

        @Test
        public void testSetAge() {
            firstPerson.setAge(18);
            assertEquals(18, firstPerson.getAge());
        }
    }

    @Nested
    @DisplayName("Setter tests for city")
    class SetterChecksForCity {

        @Test
        public void testSetterRejectsNullCity() {
            assertEquals(
                    "Null value is not allowed for city",
                    assertThrows(
                            NullPointerException.class,
                            () -> secondPerson.setCity(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSetterRejectsEmptyCity() {
            assertEquals(
                    "Blank or empty value is not allowed for city",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> secondPerson.setCity("")
                    ).getMessage()
            );
        }

        @Test
        public void testSetterRejectsBlankCity() {
            assertEquals(
                    "Blank or empty value is not allowed for city",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> secondPerson.setCity(" ")
                    ).getMessage()
            );
        }

        @Test
        public void testSetCity() {
            secondPerson.setCity("Oklahoma City, OK");
            assertEquals("Oklahoma City, OK", secondPerson.getCity());
        }
    }

    @Nested
    @DisplayName("Test Person toString method")
    class PersonToStringTest {

        @Test
        public void testFirstPersonToString() {
            List<String> stringList = Arrays.asList(firstPerson.toString().split("[,=\\]\\[]+"));
            String[] expectedTraits = {"Elmer Fudd", "43", "Hollywood"};
            for (int index = 0; index < stringList.size(); index++) {
                stringList.set(index, stringList.get(index).trim());
            }
            for (String trait : expectedTraits) {
                assertTrue(stringList.contains(trait));
            }
        }

        @Test
        public void testSecondPersonToString() {
            List<String> stringList = Arrays.asList(secondPerson.toString().split("[,=\\]\\[]+"));
            String[] expectedTraits = {"John Doe", "50", "Unknown"};
            for (int index = 0; index < stringList.size(); index++) {
                stringList.set(index, stringList.get(index).trim());
            }
            for (String trait : expectedTraits) {
                assertTrue(stringList.contains(trait));
            }
        }
    }
}
