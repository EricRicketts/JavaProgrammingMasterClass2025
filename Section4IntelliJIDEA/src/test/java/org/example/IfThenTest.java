package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IfThenTest {

    @Test
    public void testIfThen() {
        String myString = "String";
        boolean booleanVar = "String".equals(myString);
        if (booleanVar) {
            Assertions.assertTrue(booleanVar);
        }
        else  {
            Assertions.assertFalse(booleanVar);
        }
    }

    @Test
    public void testIfThenElse() {
        int weather = 2;
        String myString;
        if (weather == 1) {
            myString = "Bring an umbrella";
        } else if (weather == 2) {
            myString = "Bring sunglasses";
        }  else {
            myString = "Normal Weather";
        }
        Assertions.assertEquals("Bring sunglasses", myString);
    }

    @Test
    public void testAndOperator() {
        int weather = 2;
        String myString = "Good weather";
        String result;
        if (weather == 2 && myString.equals("Good weather")) {
            result = "Go outside";
        } else {
            result = "Stay inside";
        }
        Assertions.assertEquals("Go outside", result);
    }

    @Test
    public void testOrOperator() {
        int weather = 2;
        String myString = "Bad weather";
        String result;
        if (weather == 1 ||  myString.equals("Bad weather")) {
            result = "Stay inside";
        } else {
            result = "Go outside";
        }
        Assertions.assertEquals("Stay inside", result);
    }

    @Test
    public void testTernaryOperator() {
        String makeOfCar = "Volkswagen";
        int firstResult, secondResult;
        firstResult = makeOfCar.equals("Volkswagen") ? 0 : 1;
        makeOfCar = "Ford";
        secondResult = makeOfCar.equals("Volkswagen") ? 0 : 1;
        Assertions.assertEquals(0, firstResult);
        Assertions.assertEquals(1, secondResult);
    }

    @Test
    public void testChallengeForSection() {
        String resultString;
        Double firstDouble = 20.00D;
        Double secondDouble = 80.00D;
        Double thirdDouble = (firstDouble + secondDouble) * 100.00D;
        boolean hasRemainder = thirdDouble % 40.00D > 0;
        resultString = hasRemainder ? "Has A Remainder" : "Has No Remainder";
        Assertions.assertFalse(hasRemainder);
        Assertions.assertEquals("Has No Remainder", resultString);
    }
}
