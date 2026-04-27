package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        public void testNullValueForNameInConstructor() {
            assertEquals(
                    "Null value is not allowed for name",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person(null, 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testEmptyValueForNameInConstructor() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testBlankValueForNameInConstructor() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person(" ", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueForCityInConstructor() {
            assertEquals(
                    "Null value is not allowed for city",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person("Elmer Fudd", 43, null)
                    ).getMessage()
            );
        }

        @Test
        public void testEmptyValueForCityInConstructor() {
            assertEquals(
                    "Blank or empty value is not allowed for city",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 43, "")
                    ).getMessage()
            );
        }

        @Test
        public void testBlankValueForCityInConstructor() {
            assertEquals(
                    "Blank or empty value is not allowed for city",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 43, " ")
                    ).getMessage()
            );
        }
        @Test
        public void testNegativeValueForAgeInConstructor() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                           IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", -1, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testZeroValueForAgeInConstructor() {
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
        public void testNullValueForNameInConstructor() {
            assertEquals(
                    "Null value is not allowed for name",
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person(null, 12)
                    ).getMessage()
            );
        }

        @Test
        public void testEmptyValueForNameInConstructor() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testBlankValueForNameInConstructor() {
            assertEquals(
                    "Blank or empty value is not allowed for name",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person(" ", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testNegativeValueForAgeInConstructor() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", -4)
                    ).getMessage()
            );
        }

        @Test
        public void testZeroValueForAgeInConstructor() {
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
        public void testSetNegativeAgeForPerson() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> firstPerson.setAge(-12)
                    ).getMessage()
            );
        }

        @Test
        public void testSetZeroAgeForPerson() {
            assertEquals(
                    "Negative or zero value is not allowed for age",
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> firstPerson.setAge(0)
                    ).getMessage()
            );
        }

        @Test
        public void setAgeForPerson() {
            firstPerson.setAge(18);
            assertEquals(18, firstPerson.getAge());
        }
    }

    @Nested
    @DisplayName("Setter tests for city")
    class SetterChecksForCity {

        @Test
        public void testSetNullValueForCity() {
            assertEquals(
                    "Null value is not allowed for city",
                    assertThrows(
                            NullPointerException.class,
                            () -> secondPerson.setCity(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSetCityForPerson() {
            secondPerson.setCity("Oklahoma City, OK");
            assertEquals("Oklahoma City, OK", secondPerson.getCity());
        }
    }

    @Nested
    @DisplayName("Test Person toString method")
    class PersonToStringTest {

        @Test
        public void testToStringForFirstPerson() {
            String expected = "Person[name = Elmer Fudd, age = 43, city = Hollywood]";
            String actual = firstPerson.toString();

            assertEquals(expected, actual);
        }

        @Test
        public void testToStringForSecondPerson() {
            String expected = "Person[name = John Doe, age = 50, city = Unknown]";
            String actual = secondPerson.toString();

            assertEquals(expected, actual);
        }
    }
}
