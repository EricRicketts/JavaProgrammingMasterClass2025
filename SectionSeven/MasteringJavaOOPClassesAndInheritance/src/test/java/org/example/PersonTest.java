package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(23);
    }

    @Test
    public void testGetFirstName() {
        Assertions.assertEquals("John", person.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Assertions.assertEquals("Doe", person.getLastName());
    }

    @Test
    public void testGetAge() {
        Assertions.assertEquals(23, person.getAge());
    }

    @Test
    public void testGetAgeLessThanZero() {
        person.setAge(-1);
        Assertions.assertEquals(0, person.getAge());
    }

    @Test
    public void testGetAgeOfZero() {
        person.setAge(0);
        Assertions.assertEquals(0, person.getAge());
    }

    @Test
    public void testGetAgeGreaterThanOneHundred() {
        person.setAge(101);
        Assertions.assertEquals(0, person.getAge());
    }

    @Test
    public void testGetAgeOfOneHundred() {
        person.setAge(100);
        Assertions.assertEquals(100, person.getAge());
    }

    @Test
    public void testIsTeen() {
        boolean[] expectedArray = {false, true, true, false};
        int[] ages = {12, 13, 19, 20};
        for (int i = 0; i < expectedArray.length; i++) {
            int age = ages[i];
            person.setAge(age);
            boolean expected =  expectedArray[i];
            boolean result = person.isTeen();
            Assertions.assertEquals(expected, result);
        }
    }
}
