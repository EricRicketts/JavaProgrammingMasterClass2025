package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

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
        this.songs.remove(trackNumber - 1);
    }

}
