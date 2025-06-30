package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.Actividad;

public interface ActividadService {
    public List<Actividad> listar();
    public Optional<Actividad> listarId(int id);
    public int guardar(Actividad actividad);
    public void eliminar(int id);
}
