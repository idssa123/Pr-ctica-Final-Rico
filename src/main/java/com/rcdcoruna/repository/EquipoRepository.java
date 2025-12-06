package com.rcdcoruna.repository;

import com.rcdcoruna.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    
    List<Equipo> findByCiudad(String ciudad);
    
    List<Equipo> findByNombreContaining(String nombre);
    
    @Query("SELECT e FROM Equipo e WHERE e.ciudad = :ciudad")
    List<Equipo> buscarPorCiudad(@Param("ciudad") String ciudad);
}
