package com.example.elarayax.naves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.elarayax.naves.service.NaveService;
import com.example.elarayax.naves.model.Nave;

@RestController
@RequestMapping("/api/naves")
public class NaveController {

    @Autowired
    private NaveService naveService;

    @GetMapping
    public ResponseEntity<List<Nave>> getAllNaves() {
        List<Nave> carreras = naveService.findAll();
        if (carreras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nave> getNaveById(@PathVariable Integer id) {
        Nave nave = naveService.findById(id);
        if (nave == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nave);
    }

    @PostMapping
    public ResponseEntity<Nave> createNave(@RequestBody Nave nave) {
        Nave createdNave = naveService.save(nave);
        return ResponseEntity.status(201).body(createdNave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nave> updateNave(@PathVariable Integer id, @RequestBody Nave nave) {
        nave.setId(id);
        Nave updatedNave = naveService.save(nave);
        if (updatedNave == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(updatedNave);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Nave> partialUpdateNave(@PathVariable Integer id, @RequestBody Nave nave) {
        Nave existingNave = naveService.findById(id);
        if (existingNave == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(naveService.partialUpdate(nave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNave(@PathVariable Integer id) {
        naveService.deleteById(id);
        return ResponseEntity.noContent().build();  
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
