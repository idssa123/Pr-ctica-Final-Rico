package com.rcdcoruna.service;

import com.rcdcoruna.model.Competicion;
import com.rcdcoruna.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompeticionService {
    
    @Autowired
    private CompeticionRepository competicionRepository;
    
    public List<Competicion> obtenerTodas() {
        return competicionRepository.findAll();
    }
    
    public Optional<Competicion> obtenerPorId(Integer id) {
        return competicionRepository.findById(id);
    }
    
    public Competicion crear(Competicion competicion) {
        return competicionRepository.save(competicion);
    }
    
    public Competicion actualizar(Integer id, Competicion competicion) {
        if (competicionRepository.existsById(id)) {
            competicion.setId(id);
            return competicionRepository.save(competicion);
        }
        return null;
    }
    
    public boolean eliminar(Integer id) {
        if (competicionRepository.existsById(id)) {
            competicionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Optional<Competicion> obtenerPorNombre(String nombre) {
        return competicionRepository.findByNombre(nombre);
    }
    
    public List<Competicion> obtenerPorTipo(String tipo) {
        return competicionRepository.findByTipo(tipo);
    }
    
    public List<Competicion> obtenerPorAño(Integer año) {
        return competicionRepository.findByAño(año);
    }
}
