package com.rcdcoruna.repository;

import com.rcdcoruna.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
    
    List<Partido> findByEquipoLocalId(Integer equipoId);
    
    List<Partido> findByEquipoVisitanteId(Integer equipoId);
    
    List<Partido> findByFecha(LocalDate fecha);
    
    List<Partido> findByCompeticion(String competicion);
    
    @Query("SELECT p FROM Partido p WHERE p.equipoLocal.id = :equipoId OR p.equipoVisitante.id = :equipoId")
    List<Partido> buscarPartidosPorEquipo(@Param("equipoId") Integer equipoId);
}
