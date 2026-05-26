package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private static final String TRACK_NUMBER_TOO_LARGE =
        "The requested track number exceeds the number of songs in the play list.";

    private static final String TRACK_NUMBER_TOO_LOW =
        "The requested track number is equal to or less than zero.";

    private final List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public int numberOfSongs() {
        return this.songs.size();
    }

    public void removeSong(int trackNumber) {
        if (trackNumber <= 0) {
            throw new IndexOutOfBoundsException(TRACK_NUMBER_TOO_LOW);
        } else if (trackNumber > this.numberOfSongs()) {
            throw new IndexOutOfBoundsException(TRACK_NUMBER_TOO_LARGE);
        } else {
            this.songs.remove(trackNumber - 1);
        }
    }

}
