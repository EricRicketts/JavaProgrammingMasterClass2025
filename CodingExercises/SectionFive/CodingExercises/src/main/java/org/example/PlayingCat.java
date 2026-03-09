package org.example;

public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean playing = false;
        if (summer) {
            playing = temperature <= 45 && temperature >= 25;
        } else {
            playing = temperature <= 35 && temperature >= 25;
        }
        return playing;
    }
}
