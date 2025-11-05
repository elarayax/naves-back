package com.example.elarayax.naves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elarayax.naves.model.Usuario;
import com.example.elarayax.naves.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario partialUpdate(Usuario usuario){
        Usuario existingUsuario = usuarioRepository.findById(usuario.getId()).orElse(null);
        if (existingUsuario != null) {
            if (usuario.getNombre() != null) {
                existingUsuario.setNombre(usuario.getNombre());
            }
            if (usuario.getCorreo() != null) {
                existingUsuario.setCorreo(usuario.getContrasena());
            }

            if(usuario.getContrasena() != null) {
                existingUsuario.setContrasena(usuario.getContrasena());
            }

            if(usuario.getRol() != null) {
                existingUsuario.setRol(usuario.getRol());
            }

            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
