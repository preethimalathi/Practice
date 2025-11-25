package com.sjprogramming.restapi.controller;

//package com.sjprogramming.restapi.controller;

import com.sjprogramming.restapi.entity.Address;
import com.sjprogramming.restapi.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<Address> getById(@PathVariable int rollNo) {
        Optional<Address> addr = addressService.getAddressById(rollNo);
        return addr.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{rollNo}")
    public ResponseEntity<Address> addAddress(
            @PathVariable int rollNo,
            @RequestBody Address address) {

        Address saved = addressService.addAddress(rollNo, address);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{rollNo}")
    public ResponseEntity<Address> update(
            @PathVariable int rollNo,
            @RequestBody Address address) {

        Address updated = addressService.updateAddress(rollNo, address);
        return updated != null ? ResponseEntity.ok(updated)
                               : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> delete(@PathVariable int rollNo) {
        boolean deleted = addressService.deleteAddress(rollNo);
        return deleted ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }
}