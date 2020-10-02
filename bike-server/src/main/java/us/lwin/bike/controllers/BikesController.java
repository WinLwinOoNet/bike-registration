package us.lwin.bike.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import us.lwin.bike.models.Bike;
import us.lwin.bike.repositories.BikeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Bike get(@PathVariable long id) {
        return bikeRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }
}
