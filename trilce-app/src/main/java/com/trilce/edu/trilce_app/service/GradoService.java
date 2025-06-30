package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.Grado;

public interface GradoService {
    List<Grado> listar();
    Optional<Grado> listarId(int id);
    int guardar(Grado grado);
    void eliminar(int id);
}
