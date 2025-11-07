package com.Film.Film.Controller;

import com.Film.Film.Entity.Actor;
import com.Film.Film.Entity.Movies;
import com.Film.Film.ExceptionHandler.MovieNotFoundException;
import com.Film.Film.Repo.ActorRepository;
import com.Film.Film.Repo.MoviesRepository;
import com.Film.Film.Service.ActorService;
import com.Film.Film.Service.MoviesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    @Autowired
    private MoviesService moviesService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private ActorRepository actorRepository;

    private ObjectMapper objectMapper;

    public MovieController(MoviesService moviesService, ObjectMapper objectMapper) {
        this.moviesService = moviesService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/movies")
    public List<Movies> getMovies() {
        return moviesService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Movies getMovieById(@PathVariable int id) {
        if(moviesService.getMovieById(id)!= null) {
            return moviesService.getMovieById(id);
        }
        throw new MovieNotFoundException("Movie Not Found "+id);

    }
    @PostMapping("/movies")
    public Movies addMovie(@RequestBody Movies movie) {
        if (movie.getActor() != null && movie.getActor().getId() != 0) {
            Actor existingActor = actorRepository.findById(movie.getActor().getId())
                    .orElseThrow(() -> new RuntimeException("Actor not found with id " + movie.getActor().getId()));
            movie.setActor(existingActor);
        }
        return moviesService.addMovie(movie);
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable int id) {
        moviesService.deleteMovie(id);
    }
    @PatchMapping("/movies/{id}")
    public Movies updateMovie(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        Movies movie = moviesService.getMovieById(id);
        if(movie.getId()==0){
            throw new RuntimeException("Movie not found with id " + id);
        }
        Movies patchedMovie = apply(patchPayload,movie);
        Movies m = moviesService.saveMovie(patchedMovie);
        return m;
    }

    private Movies apply(Map<String, Object> patchPayload, Movies movie) {
        ObjectNode movieNode = objectMapper.convertValue(movie, ObjectNode.class);
        ObjectNode payloadNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        movieNode.setAll(payloadNode);
        return objectMapper.convertValue(movieNode, Movies.class);
    }


}
