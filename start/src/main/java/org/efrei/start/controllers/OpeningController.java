package org.efrei.start.controllers;


import org.efrei.start.dto.CreateOpening;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Opening;
import org.efrei.start.services.OpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/openings")
public class OpeningController {

    private final OpeningService service;

    @Autowired
    public OpeningController(OpeningService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Opening>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opening> findById(@PathVariable String id) {
        Opening opening = service.findById(id);
        if (opening == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        Opening opening = service.findById(id);
        if (opening == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateOpening createOpening) {
        service.create(createOpening);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Opening opening) {
        service.update(id, opening);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
