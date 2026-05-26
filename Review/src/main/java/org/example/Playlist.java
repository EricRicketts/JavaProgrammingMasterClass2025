package org.example;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private static final String TRACK_NUMBER_TOO_LARGE =
        "The requested track number exceeds the number of songs in the play list.";

    private static final String TRACK_NUMBER_TOO_LOW =
        "The requested track number is equal to or less than zero.";

    private static final String SONG_REMOVED =
        " successfully removed.";

    private static final String SONG_NOT_FOUND =
        " not found.";

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

    public Song getSong(int trackNumber) {
        return this.songs.get(trackNumber - 1);
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

    public String removeSong(String title) {
        int trackNumber = this.findSong(title);
        if (trackNumber > 0) {
            this.removeSong(trackNumber);
            return title.concat(SONG_REMOVED);
        } else {
            return title.concat(SONG_NOT_FOUND);
        }
    }

    private int findSong(String title) {
        for (int index = 0; index < this.numberOfSongs(); index++) {
            if (title.equals(this.songs.get(index).getTitle())) {
                return index + 1;
            }
        }
        return -1;
    }

}
