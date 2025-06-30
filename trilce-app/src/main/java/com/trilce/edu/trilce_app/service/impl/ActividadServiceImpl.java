package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.Actividad;
import com.trilce.edu.trilce_app.repository.ActividadRepository;
import com.trilce.edu.trilce_app.service.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService{
    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List<Actividad> listar() {
        return (List<Actividad>) actividadRepository.findAll();
    }

    @Override
    public Optional<Actividad> listarId(int id) {
        return actividadRepository.findById(id);
    }

    @Override
    public int guardar(Actividad actividad) {
        return actividadRepository.save(actividad) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        actividadRepository.deleteById(id);
    }

}
