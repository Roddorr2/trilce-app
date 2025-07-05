package com.trilce.edu.trilce_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilce.edu.trilce_app.model.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    List<Ejercicio> findByActividadId(int actividadId);
}
