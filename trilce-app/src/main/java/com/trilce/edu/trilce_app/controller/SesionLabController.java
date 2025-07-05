package com.trilce.edu.trilce_app.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trilce.edu.trilce_app.model.SesionLaboratorio;
import com.trilce.edu.trilce_app.model.SesionParticipante;
import com.trilce.edu.trilce_app.model.Usuario;
import com.trilce.edu.trilce_app.repository.SesionLabRepository;
import com.trilce.edu.trilce_app.repository.SesionPartRepository;
import com.trilce.edu.trilce_app.repository.UsuarioRepository;

@Controller
@RequestMapping("/sesiones")
public class SesionLabController {

    @Autowired
    private SesionLabRepository sesionRepo;

    @Autowired
    private SesionPartRepository sesionParticipanteRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    // Listar sesiones y alumnos
    @GetMapping
    public String listarSesiones(Model model) {
        List<SesionLaboratorio> sesiones = sesionRepo.findAll();
        List<SesionParticipante> participantes = sesionParticipanteRepo.findAll();

        Map<Integer, List<SesionParticipante>> participantesPorSesion = participantes.stream()
            .filter(p -> p.getSesion() != null)
            .collect(Collectors.groupingBy(p -> p.getSesion().getId()));

        model.addAttribute("sesiones", sesiones);
        model.addAttribute("participantesPorSesion", participantesPorSesion);

        // ✅ Agregamos solo alumnos
        List<Usuario> alumnos = usuarioRepo.findAll().stream()
            .filter(u -> u.getTipoUsuario().getId() == 2) // ID tipo 'Alumno'
            .collect(Collectors.toList());
        model.addAttribute("alumnos", alumnos);

        return "sesiones";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaSesion(Model model) {
        model.addAttribute("sesion", new SesionLaboratorio());
        model.addAttribute("usuarios", usuarioRepo.findAll());
        return "form_sesion";
    }

    @PostMapping
    public String guardarSesion(@ModelAttribute SesionLaboratorio sesion,
    @RequestParam(value = "usuarioIds", required = false) List<Long> usuarioIds) {
        SesionLaboratorio sesionGuardada = sesionRepo.save(sesion);

        if (usuarioIds != null) {
            for (Long usuarioId : usuarioIds) {
                Usuario usuario = usuarioRepo.findById(usuarioId.intValue()).orElse(null);
                if (usuario != null) {
                    SesionParticipante sp = new SesionParticipante();
                    sp.setSesion(sesionGuardada);
                    sp.setUsuario(usuario);
                    sesionParticipanteRepo.save(sp);
                }
            }
        }

        return "redirect:/sesiones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        SesionLaboratorio sesion = sesionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        model.addAttribute("sesion", sesion);
        model.addAttribute("usuarios", usuarioRepo.findAll());
        return "form_sesion";
    }

    @PostMapping("/registrar")
    public String registrarSesionConAlumno(@RequestParam("idUsuario") int idUsuario,
    @RequestParam("fechaHora") String fechaHoraStr) {
        try {
            LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr);

            Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
            if (usuario == null) return "redirect:/sesiones?error=usuario";

            SesionLaboratorio sesion = new SesionLaboratorio();
            sesion.setFechaHora(fechaHora);
            SesionLaboratorio sesionGuardada = sesionRepo.save(sesion);

            SesionParticipante participante = new SesionParticipante();
            participante.setSesion(sesionGuardada);
            participante.setUsuario(usuario);
            sesionParticipanteRepo.save(participante);

            return "redirect:/sesiones";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/sesiones?error=fecha";
        }
    }
}
