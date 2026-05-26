package org.example;

public class Song {


    private final String album;
    private final String artist;
    private final String title;
    private final String releaseDate;

    public Song(
        String title,
        String album,
        String artist,
        String releaseDate
    ) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }
}
