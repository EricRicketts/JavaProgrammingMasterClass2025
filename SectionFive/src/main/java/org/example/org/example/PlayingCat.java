package org.example;

public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature) {
        int lowTemp = 25;
        int highTemp = summer ? 45 : 35;

        return temperature >= lowTemp && temperature <= highTemp;
    }
}
