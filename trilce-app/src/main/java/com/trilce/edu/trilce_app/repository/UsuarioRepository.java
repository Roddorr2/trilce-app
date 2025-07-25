package com.trilce.edu.trilce_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilce.edu.trilce_app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByTipoUsuario_Nombre(String nombre); 
}
