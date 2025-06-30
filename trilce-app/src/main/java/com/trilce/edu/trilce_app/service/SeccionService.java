package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.Seccion;

public interface SeccionService {
    List<Seccion> listar();
    Optional<Seccion> listarId(int id);
    int guardar(Seccion seccion);
    void eliminar(int id);
}
