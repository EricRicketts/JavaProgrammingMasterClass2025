package org.example;

import java.math.BigDecimal;

public class Song {
    private final String title;
    private final BigDecimal duration;

    public Song(String title, BigDecimal duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
            "title='" + title + '\'' +
            ", duration=" + duration +
            '}';
    }
}
