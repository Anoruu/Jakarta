package org.efrei.start.services;


import org.efrei.start.dto.CreateOpening;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Opening;
import org.efrei.start.repositories.OpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpeningService {

    private final OpeningRepository repository;
    private final MovieService movieService;

    @Autowired
    public OpeningService(OpeningRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    public List<Opening> findAll() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    public void create(CreateOpening createOpening) {
        Opening opening = new Opening();
        Movie movie = movieService.findById(createOpening.getMovieId());
        opening.setSongname(createOpening.getSongname());
        opening.setArtist(createOpening.getArtist());
        opening.setLength(createOpening.getLength());
        opening.setMovie(movie);
        repository.save(opening);
    }

    public Opening findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Opening opening) {

        Opening updatedOpening = findById(id);
        updatedOpening.setArtist(opening.getArtist());
        updatedOpening.setSongname(opening.getSongname());
        updatedOpening.setLength(opening.getLength());
        repository.save(updatedOpening);
    }

}
