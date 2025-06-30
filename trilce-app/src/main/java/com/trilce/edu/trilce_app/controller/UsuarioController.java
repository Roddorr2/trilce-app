package com.trilce.edu.trilce_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trilce.edu.trilce_app.model.Usuario;
import com.trilce.edu.trilce_app.service.impl.UsuarioServiceImpl;
import com.trilce.edu.trilce_app.service.impl.GradoServiceImpl;
import com.trilce.edu.trilce_app.service.impl.SeccionServiceImpl;
import com.trilce.edu.trilce_app.service.impl.TipoUsuarioServiceImpl;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private GradoServiceImpl gradoService;

    @Autowired
    private SeccionServiceImpl seccionService;

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuarios";
    }

    @GetMapping("/usuarios/crear")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("grados", gradoService.listar());
        model.addAttribute("secciones", seccionService.listar());
        model.addAttribute("tipos", tipoUsuarioService.listar());
        return "/crear_usuario"; 
    }

    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        Usuario usuario = usuarioService.listarId(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("usuario", usuario);
        model.addAttribute("grados", gradoService.listar());
        model.addAttribute("secciones", seccionService.listar());
        model.addAttribute("tipos", tipoUsuarioService.listar());
        return "/editar_usuario";
    }

    @PostMapping("/usuarios/{id}")
    public String actualizarUsuario(@PathVariable int id, @ModelAttribute("usuario") Usuario usuario) {
        usuario.setId(id);
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }  
}