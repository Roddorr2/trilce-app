package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.TipoUsuario;
import com.trilce.edu.trilce_app.repository.TipoUsuarioRepository;
import com.trilce.edu.trilce_app.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public List<TipoUsuario> listar() {
        List<TipoUsuario> listar = (List<TipoUsuario>) tipoUsuarioRepository.findAll();
        return listar;
    }

    @Override
    public Optional<TipoUsuario> listarId(int id) {
        return tipoUsuarioRepository.findById(id);
    }

    @Override
    public int guardar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
