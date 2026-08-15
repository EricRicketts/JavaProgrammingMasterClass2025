package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Album {

    private String name;
    private String artist;
    SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, BigDecimal duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song foundSong = songs.findSong(trackNumber);
        if (!Objects.isNull(foundSong)) {
            playlist.add(foundSong);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        Song foundSong = songs.findSong(songTitle);
        if (!Objects.isNull(foundSong)) {
            playlist.add(foundSong);
            return true;
        }
        return false;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return this.songs.getSongs();
    }

    private static class SongList {

        List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            } else {
                songs.add(song);
                return true;
            }
        }

        Song findSong(String title) {
            for(Song song : this.getSongs()) {
                if (song.getTitle().equalsIgnoreCase(title)) {
                    return song;
                }
            }
            return null;
        }

        Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index <= songs.size()) {
                return songs.get(index);
            }
            return null;
        }

        public List<Song> getSongs() {
            return songs;
        }
    }
}
