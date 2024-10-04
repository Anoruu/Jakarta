package org.efrei.start.services;


import org.efrei.start.dto.CreateActor;
import org.efrei.start.dto.CreateRoom;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Room;
import org.efrei.start.repositories.ActorRepository;
import org.efrei.start.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repository;
    private final MovieService movieService;

    @Autowired
    public RoomService(RoomRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    public List<Room> findAll(){
        // SELECT * from actor
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    public void create(CreateRoom createRoom) {
        Room room = new Room();
        Movie movie = movieService.findById(createRoom.getMovieId());
        room.setCapacity(createRoom.getCapacity());
        room.setName(createRoom.getName());
        room.setMovie(movie);
        repository.save(room);
    }

    public Room findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Room room) {

        //UPDATE actor SET (firstname, name) VALUES (:firstname, :name) where id = :id;
        Room updatedRoom = findById(id);
        updatedRoom.setName(room.getName());
        updatedRoom.setCapacity(room.getCapacity());
        repository.save(updatedRoom);
    }

}
