
package com.example.travelbackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travelbackend.repository.DestinationRepository;
import com.example.travelbackend.model.Destination;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    @Autowired private DestinationRepository repo;

    @GetMapping("")
    public List<Destination> list(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public Destination get(@PathVariable Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("not found")); }

    @PostMapping("")
    public Destination create(@RequestBody Destination d){ return repo.save(d); }

    @PutMapping("/{id}")
    public Destination update(@PathVariable Long id, @RequestBody Destination d){
        Destination ex = repo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        ex.setName(d.getName()); ex.setRegion(d.getRegion()); ex.setShortDescription(d.getShortDescription());
        ex.setLongDescription(d.getLongDescription()); ex.setPrice(d.getPrice()); ex.setDuration(d.getDuration()); ex.setRating(d.getRating());
        ex.setImages(d.getImages());
        return repo.save(ex);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
