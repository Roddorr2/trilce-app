package com.trilce.edu.trilce_app.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sesion_participante")
public class SesionParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sesion")
    private SesionLaboratorio sesion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public SesionLaboratorio getSesion() { return sesion; }

    public void setSesion(SesionLaboratorio sesion) { this.sesion = sesion; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
