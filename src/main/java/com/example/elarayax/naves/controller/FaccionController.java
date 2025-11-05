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

import com.example.elarayax.naves.model.Faccion;
import com.example.elarayax.naves.service.FaccionesService;

@RestController
@RequestMapping("/api/facciones")
public class FaccionController {

    @Autowired
    private FaccionesService faccionService;

    @GetMapping
    public ResponseEntity<List<Faccion>> getAllFacciones() {
        List<Faccion> facciones = faccionService.findAll();
        if (facciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(facciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faccion> getFaccionById(@PathVariable Integer id) {
        Faccion faccion = faccionService.findById(id);
        if (faccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faccion);
    }

    @PostMapping
    public ResponseEntity<Faccion> createFaccion(@RequestBody Faccion faccion) {
        Faccion createdFaccion = faccionService.save(faccion);
        return ResponseEntity.status(201).body(createdFaccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faccion> updateFaccion(@PathVariable Integer id, @RequestBody Faccion faccion) {
        faccion.setId(id);
        Faccion updatedFaccion = faccionService.save(faccion);
        if (updatedFaccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFaccion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Faccion> updatePartialFaccion(@PathVariable Integer id, @RequestBody Faccion faccion) {
        faccion.setId(id);
        Faccion updatedFaccion = faccionService.partialUpdate(faccion);
        if (updatedFaccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFaccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaccion(@PathVariable Integer id) {
        faccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
