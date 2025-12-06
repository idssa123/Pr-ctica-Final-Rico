package com.rcdcoruna.repository;

import com.rcdcoruna.model.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompeticionRepository extends JpaRepository<Competicion, Integer> {
    
    Optional<Competicion> findByNombre(String nombre);
    
    List<Competicion> findByTipo(String tipo);
    
    List<Competicion> findByAño(Integer año);
    
    @Query("SELECT c FROM Competicion c WHERE c.nombre = :nombre")
    Optional<Competicion> buscarPorNombre(@Param("nombre") String nombre);
}
