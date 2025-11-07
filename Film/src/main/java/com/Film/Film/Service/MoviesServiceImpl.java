package com.Film.Film.Service;

import com.Film.Film.Entity.Movies;
import com.Film.Film.ExceptionHandler.MovieNotFoundException;
import com.Film.Film.Repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;
    @Override
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies getMovieById(int id) {
        return moviesRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id " + id));
    }


    @Override
    public Movies addMovie(Movies movie) {
        return  moviesRepository.save(movie);

    }

    @Override
    public void updateMovie(int id,Movies movie) {
        Movies m = moviesRepository.getReferenceById(id);
        m.setTitle(movie.getTitle());
        m.setYear(movie.getYear());
        m.setGenre(movie.getGenre());
        m.setActor(movie.getActor());

        moviesRepository.save(m);

    }

    @Override
    public void deleteMovie(int id) {
        moviesRepository.deleteById(id);

    }

    @Override
    public Movies saveMovie(Movies movie) {
      return   moviesRepository.save(movie);
    }
}
