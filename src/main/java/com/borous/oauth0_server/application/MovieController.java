package com.borous.oauth0_server.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    @GetMapping
    public ResponseEntity<String> findAll() {
        System.out.println("order");
        return ResponseEntity.ok().body("items");
    }

    @GetMapping("/{id}")
    public String find(@PathVariable("id") Long id) {
        return "item";
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String item) {
        return ResponseEntity.ok(item);
    }
}