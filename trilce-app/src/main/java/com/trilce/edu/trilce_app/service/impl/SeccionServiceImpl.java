package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.Seccion;
import com.trilce.edu.trilce_app.repository.SeccionRepository;
import com.trilce.edu.trilce_app.service.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService {
    @Autowired
    private SeccionRepository seccionRepository;

    @Override
    public List<Seccion> listar() {
        return (List<Seccion>) seccionRepository.findAll();
    }

    @Override
    public Optional<Seccion> listarId(int id) {
        return seccionRepository.findById(id);
    }

    @Override
    public int guardar(Seccion seccion) {
        return seccionRepository.save(seccion) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        seccionRepository.deleteById(id);
    }
}
