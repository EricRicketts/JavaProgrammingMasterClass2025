package org.example;

public record BaseballPlayer(String name, String position) implements Player {

    public String toString() {
        return "The Player name is: " + name + ", the Player position is: " + position;
    }
}
