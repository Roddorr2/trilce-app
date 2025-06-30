package com.trilce.edu.trilce_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilce.edu.trilce_app.model.SesionParticipanteId;

public interface SesionPartRepository extends JpaRepository<SesionParticipante, SesionParticipanteId> {

}
