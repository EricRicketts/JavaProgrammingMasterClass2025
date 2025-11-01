package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetAndGetFirstName() {
        person.setFirstName("Jody");
        Assertions.assertEquals("Jody", person.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        person.setLastName("Millford");
        Assertions.assertEquals("Millford", person.getLastName());
    }

    @Test
    public void testSetAndGetAge() {
        person.setAge(30);
        Assertions.assertEquals(30, person.getAge());
    }

    @Test
    public void testSetAndGetAgeUnderZero() {
        person.setAge(-1);
        Assertions.assertEquals(0, person.getAge());
    }

    @Test
    public void testSetAndGetAgeOverOneHundred() {
        person.setAge(101);
        Assertions.assertEquals(0, person.getAge());
    }

    @Test
    public void testIsTeenLessThanTwelve() {
        person.setAge(11);
        Assertions.assertFalse(person.isTeen());
    }

    @Test
    public void testIsTeenGreaterThanNineteen() {
        person.setAge(20);
        Assertions.assertFalse(person.isTeen());
    }

    @Test
    public void testGetFullNameEmptyFirstAndLastName() {
        person.setFirstName("");
        person.setLastName("");
        Assertions.assertEquals("", person.getFullName());
    }
}
