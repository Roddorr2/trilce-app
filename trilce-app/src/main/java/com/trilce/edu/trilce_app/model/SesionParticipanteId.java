package com.trilce.edu.trilce_app.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class SesionParticipanteId implements Serializable {
    private int sesionLaboratorioId;
    private int usuarioId;

    public SesionParticipanteId() {
    }

    public SesionParticipanteId(int sesionLaboratorioId, int usuarioId) {
        this.sesionLaboratorioId = sesionLaboratorioId;
        this.usuarioId = usuarioId;
    }

    public int getSesionLaboratorioId() {
        return sesionLaboratorioId;
    }

    public void setSesionLaboratorioId(int sesionLaboratorioId) {
        this.sesionLaboratorioId = sesionLaboratorioId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SesionParticipanteId that = (SesionParticipanteId) o;
        return Objects.equals(sesionLaboratorioId, that.sesionLaboratorioId) && 
                Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sesionLaboratorioId, usuarioId);
    }
}
