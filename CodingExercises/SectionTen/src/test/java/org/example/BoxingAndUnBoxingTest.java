package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoxingAndUnBoxingTest {

    private static ArrayList<Integer> getList(int... varArgs) {
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        for (int i : varArgs) {
            listOfIntegers.add(i); // Autoboxing takes place upon assignment.
        }
        return listOfIntegers;
    }
    // A primitive is wrapped or "boxed" in a containing class whose main data is the primitive value.

    Integer firstBoxedInt, secondBoxedInt, thirdBoxedInt;

    @BeforeEach
    public void setUp() {
        firstBoxedInt = Integer.valueOf(15);
        secondBoxedInt = new Integer(16); // Avoid this code which has been deprecated since JDK 9.
        thirdBoxedInt = 17; // Java supports autoboxing, this is the preferred method.
    }

    @Test
    public void testFirstBoxedInteger() {
        assertTrue(firstBoxedInt instanceof Integer);
    }

    @Test
    public void testSecondBoxedInteger() {
        assertTrue(secondBoxedInt instanceof Integer);
    }

    @Test
    public void testThirdBoxedInteger() {
        assertTrue(thirdBoxedInt instanceof Integer);
    }

    @Test
    public void testManuallyUnboxAnInteger() {
        int checkValue = 15;
        assertEquals("Integer", firstBoxedInt.getClass().getSimpleName());
        assertTrue(int.class.isPrimitive());

        int unboxedFirstInt = firstBoxedInt.intValue(); // Manually unbox.

        assertEquals(checkValue, unboxedFirstInt);
    }

    @Test
    public void testAutomaticUnboxAnInteger() {
        int thirdUnboxedInt = thirdBoxedInt;
        int checkValue = 17;

        assertEquals(checkValue, thirdUnboxedInt);
    }

    @Test
    public void testBoxingAndUnboxingAnArray() {
        Integer[] wrapperArray = new Integer[]{5, 6, 7, 8, 9};

        assertEquals("Integer", wrapperArray[0].getClass().getSimpleName());
    }

    @Test
    public void testArrayListOfIntegers() {
        var list = getList(1, 2, 3);
        for (int index = 0; index < list.size(); index++) {
            assertEquals("Integer", list.get(index).getClass().getSimpleName());
        }
    }
}
