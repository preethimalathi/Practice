
package com.example.travelbackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travelbackend.repository.BookingRepository;
import com.example.travelbackend.model.Booking;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired private BookingRepository repo;

    @PostMapping("")
    public Booking create(@RequestBody Booking b){
        b.setBookingRef(("TRV-"+UUID.randomUUID().toString().substring(0,8)).toUpperCase());
        return repo.save(b);
    }

    @GetMapping("")
    public List<Booking> list(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public Booking get(@PathVariable Long id){ return repo.findById(id).orElseThrow(()->new RuntimeException("not found")); }
}
