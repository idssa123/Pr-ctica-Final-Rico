package com.rcdcoruna.service;

import com.rcdcoruna.model.Participacion;
import com.rcdcoruna.repository.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipacionService {
    
    @Autowired
    private ParticipacionRepository participacionRepository;
    
    public List<Participacion> obtenerTodos() {
        return participacionRepository.findAll();
    }
    
    public Participacion obtenerPorId(Integer id) {
        Optional<Participacion> participacion = participacionRepository.findById(id);
        return participacion.orElse(null);
    }
    
    public Participacion crear(Participacion participacion) {
        return participacionRepository.save(participacion);
    }
    
    public Participacion actualizar(Integer id, Participacion participacion) {
        Optional<Participacion> existente = participacionRepository.findById(id);
        if (existente.isPresent()) {
            participacion.setId(id);
            return participacionRepository.save(participacion);
        }
        return null;
    }
    
    public boolean eliminar(Integer id) {
        if (participacionRepository.existsById(id)) {
            participacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Participacion> obtenerPorJugador(Integer jugadorId) {
        return participacionRepository.findByJugadorId(jugadorId);
    }
    
    public List<Participacion> obtenerPorPartido(Integer partidoId) {
        return participacionRepository.findByPartidoId(partidoId);
    }
}
