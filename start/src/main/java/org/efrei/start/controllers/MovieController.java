package org.efrei.start.controllers;

import org.efrei.start.dto.CreateMovie;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieService service;
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService service, MovieService movieService) {
        this.service = service;
        this.movieService = movieService;
    }
    
    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        Movie movie = service.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateMovie createMovie) {
        service.create(createMovie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Movie movie) {
        service.update(id, movie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
