package com.Film.Film.Service;

import com.Film.Film.Entity.Movies;

import java.util.List;

public interface MoviesService {
    List<Movies> getAllMovies();
    Movies getMovieById(int id);
    Movies addMovie(Movies movie);
    void updateMovie(int id,Movies movie);
    void deleteMovie(int id);
    Movies saveMovie(Movies movie);
}
