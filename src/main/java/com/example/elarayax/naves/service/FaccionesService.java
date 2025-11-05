package com.example.elarayax.naves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elarayax.naves.model.Faccion;
import com.example.elarayax.naves.repository.FaccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class FaccionesService {

    @Autowired
    private FaccionRepository faccionRepository;

    public List<Faccion> findAll() {
        return faccionRepository.findAll();
    }

    public Faccion findById(Integer id) {
        Faccion faccion = faccionRepository.findById(id).orElse(null);
        return faccion;
    }

    public Faccion save(Faccion faccion) {
        return faccionRepository.save(faccion);
    }

    public Faccion partialUpdate(Faccion faccion){
        Faccion existingFaccion = faccionRepository.findById(faccion.getId()).orElse(null);
        if (existingFaccion != null) {
            if (faccion.getNombre() != null) {
                existingFaccion.setNombre(faccion.getNombre());
            }

            if(faccion.getDescripcion() != null) {
                existingFaccion.setDescripcion(faccion.getDescripcion());
            }

            if(faccion.getLogo() != null) {
                existingFaccion.setLogo(faccion.getLogo());
            }

            return faccionRepository.save(existingFaccion);
        }
        return null;
    }

    public void deleteById(Integer id) {
        faccionRepository.deleteById(id);
    }
}
