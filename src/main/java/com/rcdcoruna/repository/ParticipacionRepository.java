package com.rcdcoruna.repository;

import com.rcdcoruna.model.Participacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipacionRepository extends JpaRepository<Participacion, Integer> {
    
    List<Participacion> findByJugadorId(Integer jugadorId);
    
    List<Participacion> findByPartidoId(Integer partidoId);
    
    @Query("SELECT p FROM Participacion p WHERE p.jugador.id = :jugadorId")
    List<Participacion> buscarPorJugador(@Param("jugadorId") Integer jugadorId);
    
    @Query("SELECT p FROM Participacion p WHERE p.partido.id = :partidoId")
    List<Participacion> buscarPorPartido(@Param("partidoId") Integer partidoId);
    
    @Query("SELECT p FROM Participacion p WHERE p.goles > 0")
    List<Participacion> buscarParticipacionesConGoles();
}
