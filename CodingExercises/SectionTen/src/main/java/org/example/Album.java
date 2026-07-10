package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Album {

    private String name, artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, BigDecimal duration) {
        var song = new Song(title, duration);
        if (findSong(song.title()) == null) {
            this.songs.add(song);
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.title().equals(title)) return song;
        }
        return null;
    }

    public boolean addToPlayList(int albumTrackNumber, LinkedList<Song> playlist) {
        if (albumTrackNumber >= 1 && albumTrackNumber <= songs.size()) {
            Song song = songs.get(albumTrackNumber - 1);
            playlist.add(song);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
