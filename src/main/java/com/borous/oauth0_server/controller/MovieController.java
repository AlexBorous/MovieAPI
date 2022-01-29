package com.borous.oauth0_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    @GetMapping
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok().body("items");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body("item");
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody String item) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item)
                .toUri();
        return ResponseEntity.created(location).body(item);
    }
}