package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.Grado;
import com.trilce.edu.trilce_app.repository.GradoRepository;
import com.trilce.edu.trilce_app.service.GradoService;

@Service
public class GradoServiceImpl implements GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    @Override
    public List<Grado> listar() {
        return (List<Grado>) gradoRepository.findAll();
    }

    @Override
    public Optional<Grado> listarId(int id) {
        return gradoRepository.findById(id);
    }

    @Override
    public int guardar(Grado grado) {
        return gradoRepository.save(grado) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        gradoRepository.deleteById(id);
    }
}
