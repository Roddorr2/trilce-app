package com.trilce.edu.trilce_app.service;

import java.util.List;
import java.util.Optional;

import com.trilce.edu.trilce_app.model.TipoUsuario;

public interface TipoUsuarioService {
    List<TipoUsuario> listar();
    Optional<TipoUsuario> listarId(int id);
    int guardar(TipoUsuario tipoUsuario);
    void eliminar(int id);
}
