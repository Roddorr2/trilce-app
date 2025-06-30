package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.Categoria;

public interface CategoriaService {
    public List<Categoria> listar();
    public Optional<Categoria> listarId(int id);
    public int guardar(Categoria categoria);
    public void eliminar(int id);
}
