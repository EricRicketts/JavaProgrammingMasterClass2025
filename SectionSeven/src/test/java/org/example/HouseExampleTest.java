package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseExampleTest {

    HouseExample firstHouse, secondHouse, thirdHouse;
    int firstHouseReference, secondHouseReference, thirdHouseReference;
    boolean testReferenceEquality;

    @BeforeEach
    public void setUp() {
        firstHouse = new HouseExample("blue");
        firstHouseReference = System.identityHashCode(firstHouse);
        secondHouse = new HouseExample("yellow");
        secondHouseReference = System.identityHashCode(secondHouse);
        thirdHouse = new HouseExample("green");
        thirdHouseReference = System.identityHashCode(thirdHouse);
    }

    @Test
    public void testAllReferencesAreDifferent() {
        testReferenceEquality =
            (firstHouseReference != secondHouseReference) &&
            (secondHouseReference != thirdHouseReference) &&
            (firstHouseReference != thirdHouseReference);
        assertTrue(testReferenceEquality);
    }

    @Test
    public void testMakeFirstAndSecondHousePointToTheSameObject() {
        /*
            This code is important to understand.  I set the secondHouse variable to
            equal the firstHouse variable.  Java holds references to objects in variables,
            not copies of objects.  Now the secondHouse variable contains a reference to the
            firstHouse object.  We can see this because when I got a new identity hash
            code for the secondHouse, it was the same reference as the firstHouse object.
        */
        secondHouse = firstHouse;
        secondHouseReference = System.identityHashCode(secondHouse);
        testReferenceEquality =
            (firstHouseReference == secondHouseReference) &&
            (firstHouseReference != thirdHouseReference);
        assertTrue(testReferenceEquality);
    }

    @Test
    public void testChangeAttributesOfAnObject() {
        /*
            FirstHouse and secondHouse are different objects with different colors.
            When I set the secondHouse to the firstHouse, both variables now reference the
            firstHouse, so they both have the same colors and the same references.
        */
        assertEquals("blue", firstHouse.getColor());
        assertEquals("yellow", secondHouse.getColor());
        secondHouse = firstHouse;
        secondHouseReference = System.identityHashCode(secondHouse);
        testReferenceEquality = (firstHouseReference == secondHouseReference);
        assertTrue(testReferenceEquality);
        assertArrayEquals(new String[]{"blue", "blue"},
                new String[]{firstHouse.getColor(), secondHouse.getColor()});
    }

    @Test
    public void testMovingReferencesBetweenThreeObjects() {
        /*
            References can be changed any number of times.  In the situation
            below I set the firstHouse to secondHouse, so now the firstHouse variable
            references the secondHouse object.  Then I set the firstHouse variable to
            the thirdHouse variable.  This means the firstHouse variable now references
            the thirdHouse object.
        */
        firstHouse = secondHouse;
        firstHouseReference = System.identityHashCode(firstHouse);
        testReferenceEquality = (firstHouseReference == secondHouseReference);
        assertTrue(testReferenceEquality);
        assertArrayEquals(new String[]{"yellow", "yellow"},
                new String[]{firstHouse.getColor(), secondHouse.getColor()});
        firstHouse = thirdHouse;
        firstHouseReference = System.identityHashCode(firstHouse);
        testReferenceEquality = (firstHouseReference == thirdHouseReference);
        assertTrue(testReferenceEquality);
        assertArrayEquals(new String[]{"green", "green"},
                new String[]{firstHouse.getColor(), thirdHouse.getColor()});
    }
}
