package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person person;
    String expected, result;

    @BeforeEach
    public void setUp() {
        person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(15);
    }

    @Test
    public void testFullName() {
        expected = "John Doe";
        result = person.getFullName();
        assertEquals(expected, result);
    }

    @Test
    public void testNoName() {
        person.setFirstName("");
        person.setLastName("");
        expected = "";
        result = person.getFullName();
        assertEquals(expected, result);
    }

    @Test
    public void testNoLastName() {
        person.setLastName("");
        expected = "John";
        result = person.getFullName().trim();
        assertEquals(expected, result);
    }

    @Test
    public void testNoFirstName() {
        person.setFirstName("");
        expected = "Doe";
        result = person.getFullName().trim();
        assertEquals(expected, result);
    }

    @Test
    public void testIsTeen() {
        assertTrue(person.isTeen());
    }

    @Test
    public void testIsNotTeen() {
        int[] ages = {12, 20};
        for (int age : ages) {
            person.setAge(age);
            assertFalse(person.isTeen());
        }
    }
}
