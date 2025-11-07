package com.Film.Film.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {
    @Id

    @Column(name = "id")
    private int mo_id;
    @Column(name = "name")
    private String title;
    private String genre;
    private int year;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    @JsonBackReference
    private Actor actor;


    public Movies() {
    }

    public Movies(int id, String title, String genre, int year, Actor actor) {
        this.mo_id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.actor = actor;

    }

    public int getId() {
        return mo_id;
    }

    public void setId(int id) {
        this.mo_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }



    @Override
    public String toString() {
        return "Movies{" +
                "id=" + mo_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", actor=" + actor +

                '}';
    }
}
