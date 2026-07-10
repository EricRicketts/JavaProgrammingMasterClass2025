package org.example;

import java.math.BigDecimal;

public record Song(String title, BigDecimal duration) {

    @Override
    public String toString() {
        return title + ": " + duration;
    }
}
