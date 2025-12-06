package com.rcdcoruna.repository;

import com.rcdcoruna.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    
    List<Jugador> findByEquipoId(Integer equipoId);
    
    List<Jugador> findByPosicion(String posicion);
    
    List<Jugador> findByNombreContaining(String nombre);
    
    @Query("SELECT j FROM Jugador j WHERE j.equipo.id = :equipoId")
    List<Jugador> buscarPorEquipo(@Param("equipoId") Integer equipoId);
    
    @Query("SELECT j FROM Jugador j WHERE j.posicion = :posicion")
    List<Jugador> buscarPorPosicion(@Param("posicion") String posicion);
}
