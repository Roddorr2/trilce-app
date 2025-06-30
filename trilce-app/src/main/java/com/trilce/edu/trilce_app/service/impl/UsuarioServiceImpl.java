package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.Usuario;
import com.trilce.edu.trilce_app.repository.UsuarioRepository;
import com.trilce.edu.trilce_app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        List<Usuario> listar = (List<Usuario>) usuarioRepository.findAll();
        return listar;
    }

    @Override
    public Optional<Usuario> listarId(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public int guardar(Usuario usuario) {
        return usuarioRepository.save(usuario) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }

}
