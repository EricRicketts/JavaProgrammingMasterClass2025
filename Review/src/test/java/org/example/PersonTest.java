package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankName() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person(" ", 43, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNullCity() {
            assertEquals(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_CITY.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person("Elmer Fudd", 43, null)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsEmptyCity() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 43, "")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankCity() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", 43, " ")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNegativeAge() {
            assertEquals(
                    ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage(),
                    assertThrows(
                           IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", -1, "Hollywood")
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsZeroAge() {
            assertEquals(
                    ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage(),
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
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> new Person(null, 12)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsEmptyName() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("", 43)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsBlankName() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person(" ", 43)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsNegativeAge() {
            assertEquals(
                    ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Person("Elmer Fudd", -4)
                    ).getMessage()
            );
        }

        @Test
        public void testConstructorRejectsZeroAge() {
            assertEquals(
                    ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage(),
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
                    ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> firstPerson.setAge(-12)
                    ).getMessage()
            );
        }

        @Test
        public void testSetterRejectsZeroAge() {
            assertEquals(
                    ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_AGE.getErrorMessage(),
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
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_CITY.getErrorMessage(),
                    assertThrows(
                            NullPointerException.class,
                            () -> secondPerson.setCity(null)
                    ).getMessage()
            );
        }

        @Test
        public void testSetterRejectsEmptyCity() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage(),
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> secondPerson.setCity("")
                    ).getMessage()
            );
        }

        @Test
        public void testSetterRejectsBlankCity() {
            assertEquals(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_CITY.getErrorMessage(),
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
            String result = firstPerson.toString();

            assertTrue(result.contains("Elmer Fudd"));
            assertTrue(result.contains("43"));
            assertTrue(result.contains("Hollywood"));
        }

        @Test
        public void testSecondPersonToString() {
            String result = secondPerson.toString();

            assertTrue(result.contains("John Doe"));
            assertTrue(result.contains("50"));
            assertTrue(result.contains("Unknown"));
        }
    }
}
