package org.example;

import org.jetbrains.annotations.NotNull;

public record Coordinate(int x, int y) {

    @Override
    @NotNull
    public String toString() {
        return String.format(
                "X coordinate = %d%n" +
                "Y coordinate = %d%n", x, y
        ).trim();
    }
}
