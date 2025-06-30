package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.SesionLaboratorio;

public interface SesionLabService {
    List<SesionLaboratorio> listar();
    Optional<SesionLaboratorio> listarId(int id);
    int guardar(SesionLaboratorio sesionLaboratorio);
    void eliminar(int id);
}
