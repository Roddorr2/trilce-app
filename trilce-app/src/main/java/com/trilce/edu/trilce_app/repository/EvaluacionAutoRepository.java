package com.trilce.edu.trilce_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilce.edu.trilce_app.model.EvaluacionAuto;

public interface EvaluacionAutoRepository extends JpaRepository<EvaluacionAuto, Integer> {
    List<EvaluacionAuto> findByActividadId(int actividadId);
}
