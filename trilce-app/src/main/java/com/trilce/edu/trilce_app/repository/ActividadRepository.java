package com.trilce.edu.trilce_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trilce.edu.trilce_app.model.Actividad;

public interface ActividadRepository extends CrudRepository<Actividad, Integer> {

    void deleteBySesionLaboratorioId(int sesionId); // Corrección aquí

    List<Actividad> findBySesionLaboratorioId(int sesionId);
}
