package com.Film.Film.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {
    @Id

    private int id;
    private String name;
    private int age;
    private int remuneration;
    @OneToMany(mappedBy = "actor",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Movies> movies;
    public Actor() {}

    public Actor(int id, String name, int age, int remuneration, List<Movies> movies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remuneration = remuneration;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(int remuneration) {
        this.remuneration = remuneration;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remuneration=" + remuneration +
                ", movies=" + movies +
                '}';
    }
}

