package org.efrei.start.models;
import jakarta.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Actor(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
    }


    public org.efrei.start.models.Movie getMovie() {
        return movie;
    }

    public void setMovie(org.efrei.start.models.Movie movie) {
        this.movie = movie;
    }


    public Actor() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
