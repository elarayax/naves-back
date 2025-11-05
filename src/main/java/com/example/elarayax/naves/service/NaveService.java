package com.example.elarayax.naves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elarayax.naves.model.Nave;
import com.example.elarayax.naves.repository.NaveRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NaveService {

    @Autowired
    private NaveRepository naveRepository;

    public List<Nave> findAll() {
        return naveRepository.findAll();
    }
}
