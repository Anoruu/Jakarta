package org.efrei.start.models;

import jakarta.persistence.*;

@Entity
public class Opening {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name= "songname", nullable = false)
    private String songname;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "length", nullable = false)
    private int length;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
