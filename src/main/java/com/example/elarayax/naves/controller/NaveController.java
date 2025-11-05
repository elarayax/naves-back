package com.example.elarayax.naves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
