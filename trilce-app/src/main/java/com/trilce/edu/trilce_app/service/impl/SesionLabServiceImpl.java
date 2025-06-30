package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.SesionLaboratorio;
import com.trilce.edu.trilce_app.repository.SesionLabRepository;
import com.trilce.edu.trilce_app.service.SesionLabService;

@Service
public class SesionLabServiceImpl implements SesionLabService {
    @Autowired
    private SesionLabRepository sesionLabRepository;

    @Override
    public List<SesionLaboratorio> listar() {
        List<SesionLaboratorio> listar = (List<SesionLaboratorio>) sesionLabRepository.findAll();
        return listar;
    }

    @Override
    public Optional<SesionLaboratorio> listarId(int id) {
        return sesionLabRepository.findById(id);
    }

    @Override
    public int guardar(SesionLaboratorio sesionLaboratorio) {
        return sesionLabRepository.save(sesionLaboratorio) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        sesionLabRepository.deleteById(id);
    }

}
