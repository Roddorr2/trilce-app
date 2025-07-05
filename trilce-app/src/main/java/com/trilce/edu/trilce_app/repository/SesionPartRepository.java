package com.trilce.edu.trilce_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.trilce.edu.trilce_app.model.SesionParticipante;
import com.trilce.edu.trilce_app.model.Usuario;

public interface SesionPartRepository extends JpaRepository<SesionParticipante, Long> {

    @Query("SELECT sp.usuario FROM SesionParticipante sp WHERE sp.sesion.id = :idSesion")
    List<Usuario> findUsuariosBySesion(@Param("idSesion") Long idSesion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sesion_participante (id_sesion, id_usuario) VALUES (:idSesion, :idUsuario)", nativeQuery = true)
    void insertarParticipante(@Param("idSesion") Long idSesion, @Param("idUsuario") Long idUsuario);

    @Transactional
    @Modifying
    @Query("DELETE FROM SesionParticipante sp WHERE sp.sesion.id = :sesionId")
    void deleteBySesionId(int sesionId);
}
