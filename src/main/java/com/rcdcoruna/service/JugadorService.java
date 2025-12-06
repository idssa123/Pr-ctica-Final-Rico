package com.rcdcoruna.service;

import com.rcdcoruna.dto.JugadorDTO;
import com.rcdcoruna.model.Jugador;
import com.rcdcoruna.repository.JugadorRepository;
import com.rcdcoruna.repository.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorService {
    
    @Autowired
    private JugadorRepository jugadorRepository;
    
    @Autowired
    private ParticipacionRepository participacionRepository;
    
    public List<JugadorDTO> obtenerTodos() {
        return jugadorRepository.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    public Optional<JugadorDTO> obtenerPorId(Integer id) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        return jugador.map(this::convertirADTO);
    }
    
    public JugadorDTO crear(Jugador jugador) {
        Jugador guardado = jugadorRepository.save(jugador);
        return convertirADTO(guardado);
    }
    
    public JugadorDTO actualizar(Integer id, Jugador jugador) {
        Optional<Jugador> existente = jugadorRepository.findById(id);
        if (existente.isPresent()) {
            jugador.setId(id);
            Jugador actualizado = jugadorRepository.save(jugador);
            return convertirADTO(actualizado);
        }
        return null;
    }
    
    public boolean eliminar(Integer id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<JugadorDTO> obtenerPorEquipo(Integer equipoId) {
        return jugadorRepository.findByEquipoId(equipoId).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    public List<JugadorDTO> obtenerPorPosicion(String posicion) {
        return jugadorRepository.findByPosicion(posicion).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    private JugadorDTO convertirADTO(Jugador jugador) {
        JugadorDTO dto = new JugadorDTO();
        dto.setId(jugador.getId());
        dto.setNombre(jugador.getNombre());
        dto.setNumeroCamiseta(jugador.getNumeroCamiseta());
        dto.setPosicion(jugador.getPosicion());
        dto.setAltura(jugador.getAltura());
        dto.setPeso(jugador.getPeso());
        dto.setEquipoId(jugador.getEquipo().getId());
        dto.setNombreEquipo(jugador.getEquipo().getNombre());
        
        Integer goles = participacionRepository.findByJugadorId(jugador.getId()).stream()
            .mapToInt(p -> p.getGoles() != null ? p.getGoles() : 0)
            .sum();
        dto.setTotalGoles(goles);
        
        return dto;
    }
}
