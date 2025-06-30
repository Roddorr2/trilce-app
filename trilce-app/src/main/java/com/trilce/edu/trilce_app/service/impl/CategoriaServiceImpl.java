package com.trilce.edu.trilce_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilce.edu.trilce_app.model.Categoria;
import com.trilce.edu.trilce_app.repository.CategoriaRepository;
import com.trilce.edu.trilce_app.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> listarId(int id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public int guardar(Categoria categoria) {
        return categoriaRepository.save(categoria) != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        categoriaRepository.deleteById(id);
    }
}
