package com.example.elarayax.naves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elarayax.naves.model.Nave;
import com.example.elarayax.naves.repository.NaveRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class NaveService {

    @Autowired
    private NaveRepository naveRepository;

    public List<Nave> findAll() {
        return naveRepository.findAll();
    }

    public Nave findById(Integer id) {
        Nave nave = naveRepository.findById(id).orElse(null);
        return nave;
    }

    public Nave save(Nave nave) {
        return naveRepository.save(nave);
    }

    public Nave partialUpdate(Nave nave){
        Nave existingNave = naveRepository.findById(nave.getId()).orElse(null);
        if (existingNave != null) {
            if (nave.getNombre() != null) {
                existingNave.setNombre(nave.getNombre());
            }

            if(nave.getModelo() != null) {
                existingNave.setModelo(nave.getModelo());
            }

            if(nave.getFaccion() != null) {
                existingNave.setFaccion(nave.getFaccion());
            }

            return naveRepository.save(existingNave);
        }
        return null;
    }

    public void deleteById(Integer id) {
        naveRepository.deleteById(id);
    }

    public void deleteByFaccionId(Integer faccionId) {
        List<Nave> naves = naveRepository.findAll();
        for (Nave nave : naves) {
            if (nave.getFaccion() != null && nave.getFaccion().getId().equals(faccionId)) {
                naveRepository.deleteById(nave.getId());
            }
        }
    }

    public void deleteByUsuarioId(Integer usuarioId) {
        List<Nave> naves = naveRepository.findAll();
        for (Nave nave : naves) {
            if (nave.getUsuario() != null && nave.getUsuario().getId().equals(usuarioId)) {
                naveRepository.deleteById(nave.getId());
            }
        }
    }

    public List<Nave> findByFaccionId(Integer faccionId) {
        return naveRepository.findByFaccionId(faccionId);
    }

    public List<Nave> findByUsuarioId(Integer usuarioId) {
        return naveRepository.findByUsuarioId(usuarioId);
    }

    public List<Nave> findUltimas5ByFaccionId(Integer faccionId) {
        return naveRepository.findTop5ByFaccionIdOrderByIdDesc(faccionId);
    }
}
