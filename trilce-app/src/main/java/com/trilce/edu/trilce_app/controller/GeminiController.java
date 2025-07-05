package com.trilce.edu.trilce_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeminiController {

    @GetMapping("/gemini")
    public String mostrarGemini() {
        return "gemini"; // Este debe coincidir con el nombre del HTML sin extensión
    }
}