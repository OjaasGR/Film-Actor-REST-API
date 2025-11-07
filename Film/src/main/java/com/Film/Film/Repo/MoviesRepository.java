package com.Film.Film.Repo;

import com.Film.Film.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}
