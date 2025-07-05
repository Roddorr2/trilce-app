package com.trilce.edu.trilce_app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trilce.edu.trilce_app.model.Actividad;
import com.trilce.edu.trilce_app.model.Documento;
import com.trilce.edu.trilce_app.model.Ejercicio;
import com.trilce.edu.trilce_app.model.EvaluacionAuto;
import com.trilce.edu.trilce_app.repository.ActividadRepository;
import com.trilce.edu.trilce_app.repository.DocumentoRepository;
import com.trilce.edu.trilce_app.repository.EjercicioRepository;
import com.trilce.edu.trilce_app.repository.EvaluacionAutoRepository;

@Controller
public class ActividadDetalleController {

    @Autowired
    private ActividadRepository actividadRepo;

    @Autowired
    private EjercicioRepository ejercicioRepo;

    @Autowired
    private EvaluacionAutoRepository evaluacionRepo;

    @Autowired
    private DocumentoRepository documentoRepo;

    @GetMapping("/actividades")
    public String mostrarDetalleActividades(Model model) {
        List<Actividad> actividades = actividadRepo.findAll();

        List<Map<String, Object>> datosActividades = actividades.stream().map(actividad -> {
            Map<String, Object> fila = new LinkedHashMap<>();
            fila.put("actividad", actividad.getActividad());
            fila.put("entradaUsuario", actividad.getEntradaUsuario());
            fila.put("fechaHora", actividad.getFechaHora());
            fila.put("respuesta", actividad.getRespuesta());
            fila.put("nombreCategoria", actividad.getCategoria() != null ? actividad.getCategoria().getNombre() : "");

            // Ejercicio
            Ejercicio ejercicio = ejercicioRepo.findByActividadId(actividad.getId()).stream().findFirst().orElse(null);
            fila.put("pregunta", ejercicio != null ? ejercicio.getPregunta() : "");
            fila.put("respuestaCorrecta", ejercicio != null ? ejercicio.getRespuestaCorrecta() : "");
            fila.put("tipoPregunta", ejercicio != null ? ejercicio.getTipoPregunta() : "");

            // Evaluación
            EvaluacionAuto evaluacion = evaluacionRepo.findByActividadId(actividad.getId()).stream().findFirst().orElse(null);
            fila.put("comentario", evaluacion != null ? evaluacion.getComentario() : "");
            fila.put("puntaje", evaluacion != null ? evaluacion.getPuntaje() : "");

            // Documento
            Documento documento = documentoRepo.findAll().stream()
                    .filter(d -> d.getActividad().getId() == actividad.getId())
                    .findFirst()
                    .orElse(null);
            fila.put("nombreArchivo", documento != null ? documento.getNombreArchivo() : "");
            fila.put("textoExtraido", documento != null ? documento.getTextoExtraido() : "");

            return fila;
        }).collect(Collectors.toList());

        model.addAttribute("datosActividades", datosActividades);
        return "actividades";
    }
}
