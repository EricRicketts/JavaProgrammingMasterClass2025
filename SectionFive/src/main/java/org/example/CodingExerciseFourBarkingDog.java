package org.example;

public class CodingExerciseFourBarkingDog {

    public boolean shouldWakeUp(boolean barking, int hourOfDay) {
        boolean wakeUp = (hourOfDay >= 0 && hourOfDay < 8) || hourOfDay == 23;

        return barking &&  wakeUp;
    }
}
