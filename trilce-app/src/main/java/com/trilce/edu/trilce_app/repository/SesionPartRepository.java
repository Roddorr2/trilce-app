package com.trilce.edu.trilce_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilce.edu.trilce_app.model.SesionParticipante;
import com.trilce.edu.trilce_app.model.SesionParticipanteId;
import com.trilce.edu.trilce_app.model.Usuario;

public interface SesionPartRepository extends JpaRepository<SesionParticipante, SesionParticipanteId> {
    List<SesionParticipante> findByUsuario(Usuario usuario);
}
