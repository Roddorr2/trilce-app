package com.trilce.edu.trilce_app.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class SesionParticipante {

    @EmbeddedId
    private SesionParticipanteId id;

    @ManyToOne
    @MapsId("sesionLaboratorioId")
    @JoinColumn(name = "id_sesion")
    private SesionLaboratorio sesion;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public SesionParticipante() {}

    public SesionParticipante(SesionLaboratorio sesion, Usuario usuario) {
        this.sesion = sesion;
        this.usuario = usuario;
        this.id = new SesionParticipanteId(sesion.getId(), usuario.getId());
    }

    public SesionParticipanteId getId() {
        return id;
    }

    public void setId(SesionParticipanteId id) {
        this.id = id;
    }

    public SesionLaboratorio getSesion() {
        return sesion;
    }

    public void setSesion(SesionLaboratorio sesion) {
        this.sesion = sesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}