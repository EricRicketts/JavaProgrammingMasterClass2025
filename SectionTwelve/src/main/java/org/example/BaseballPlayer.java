package org.example;

public record BaseballPlayer(String name, String position) implements Player {


    public String name() {
        return name;
    }

    public String position() {
        return position;
    }

    public String toString() {
        return "The Player name is: " + name + ", the Player position is: " + position;
    }
}
