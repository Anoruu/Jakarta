package org.efrei.start.models;
import jakarta.persistence.*;
import org.efrei.start.global.Category;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie(String title, String synopsis, String kv) {
        this.title = title;
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
