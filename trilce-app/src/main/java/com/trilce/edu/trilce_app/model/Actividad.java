package com.trilce.edu.trilce_app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String actividad;
    private LocalDateTime fechaHora;
    private String entradaUsuario;
    private String respuesta;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_sesion", referencedColumnName = "id")
    private SesionLaboratorio sesionLaboratorio;
    
    public Actividad() {
    }

    public Actividad(int id, String actividad, LocalDateTime fechaHora, String entradaUsuario, String respuesta,
            Categoria categoria, SesionLaboratorio sesionLaboratorio) {
        this.id = id;
        this.actividad = actividad;
        this.fechaHora = fechaHora;
        this.entradaUsuario = entradaUsuario;
        this.respuesta = respuesta;
        this.categoria = categoria;
        this.sesionLaboratorio = sesionLaboratorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEntradaUsuario() {
        return entradaUsuario;
    }

    public void setEntradaUsuario(String entradaUsuario) {
        this.entradaUsuario = entradaUsuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SesionLaboratorio getSesionLaboratorio() {
        return sesionLaboratorio;
    }

    public void setSesionLaboratorio(SesionLaboratorio sesionLaboratorio) {
        this.sesionLaboratorio = sesionLaboratorio;
    }

    

}
