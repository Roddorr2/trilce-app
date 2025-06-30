package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.Usuario;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> listarId(int id);
    int guardar(Usuario usuario);
    void eliminar(int id);
}
