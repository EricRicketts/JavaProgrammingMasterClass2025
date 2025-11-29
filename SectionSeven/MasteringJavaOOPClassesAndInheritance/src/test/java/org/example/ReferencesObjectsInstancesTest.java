package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReferencesObjectsInstancesTest {

    House firstHouse, secondHouse, thirdHouse;
    int firstHouseHashCode, secondHouseHashCode, thirdHouseHashCode;

    @BeforeEach
    public void setUp() {
        firstHouse = new House("red");
        secondHouse = new House("green");
        thirdHouse = new House("red");
        firstHouseHashCode = System.identityHashCode(firstHouse);
        secondHouseHashCode = System.identityHashCode(secondHouse);
        thirdHouseHashCode = System.identityHashCode(thirdHouse);
    }

    @Test
    public void testGetObjectHashCodes() {
        /*
        Returns the same hash code for the given object as would be returned
        by the default method hashCode(), whether or not the given object's class
        overrides hashCode(). The hash code for the null reference is zero.

        So this is the best we can do for having a unique reference for each
        object.  Below the three hash codes should be different.

        We can see the first and third house are different houses, as they have
        different references, but they are the same color.  So we just have two
        different houses of the same color.  Going back to the instructor's analogy,
        we have two red houses of which the blueprints might be identical but they
        are at different street addresses, so they are unique by street address.
        */
        Assertions.assertTrue((firstHouseHashCode != secondHouseHashCode) &&
                (firstHouseHashCode != thirdHouseHashCode) &&
                (secondHouseHashCode != thirdHouseHashCode));
        Assertions.assertEquals(firstHouse.getColor(), thirdHouse.getColor());
    }
}
