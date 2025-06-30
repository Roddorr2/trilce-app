package com.trilce.edu.trilce_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EvaluacionAuto {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private int puntaje;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "id_actividad", referencedColumnName = "id")
    private Actividad actividad;

    public EvaluacionAuto() {
    }

    public EvaluacionAuto(int id, int puntaje, String comentario, Actividad actividad) {
        this.id = id;
        this.puntaje = puntaje;
        this.comentario = comentario;
        this.actividad = actividad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    
}
