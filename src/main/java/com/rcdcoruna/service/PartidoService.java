package com.rcdcoruna.service;

import com.rcdcoruna.dto.PartidoDTO;
import com.rcdcoruna.model.Partido;
import com.rcdcoruna.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoService {
    
    @Autowired
    private PartidoRepository partidoRepository;
    
    public List<PartidoDTO> obtenerTodos() {
        return partidoRepository.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    public Optional<PartidoDTO> obtenerPorId(Integer id) {
        Optional<Partido> partido = partidoRepository.findById(id);
        return partido.map(this::convertirADTO);
    }
    
    public PartidoDTO crear(Partido partido) {
        Partido guardado = partidoRepository.save(partido);
        return convertirADTO(guardado);
    }
    
    public PartidoDTO actualizar(Integer id, Partido partido) {
        Optional<Partido> existente = partidoRepository.findById(id);
        if (existente.isPresent()) {
            partido.setId(id);
            Partido actualizado = partidoRepository.save(partido);
            return convertirADTO(actualizado);
        }
        return null;
    }
    
    public boolean eliminar(Integer id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<PartidoDTO> obtenerPorEquipo(Integer equipoId) {
        return partidoRepository.buscarPartidosPorEquipo(equipoId).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    public List<PartidoDTO> obtenerPorFecha(LocalDate fecha) {
        return partidoRepository.findByFecha(fecha).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    public List<PartidoDTO> obtenerPorCompeticion(String competicion) {
        return partidoRepository.findByCompeticion(competicion).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    private PartidoDTO convertirADTO(Partido partido) {
        PartidoDTO dto = new PartidoDTO();
        dto.setId(partido.getId());
        dto.setEquipoLocalNombre(partido.getEquipoLocal().getNombre());
        dto.setEquipoVisitanteNombre(partido.getEquipoVisitante().getNombre());
        dto.setFecha(partido.getFecha());
        dto.setGolesLocal(partido.getGolesLocal());
        dto.setGolesVisitante(partido.getGolesVisitante());
        dto.setEstadio(partido.getEstadio());
        dto.setCompeticion(partido.getCompeticion());
        
        String resultado;
        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            resultado = "Victoria local";
        } else if (partido.getGolesLocal() < partido.getGolesVisitante()) {
            resultado = "Victoria visitante";
        } else {
            resultado = "Empate";
        }
        dto.setResultado(resultado);
        
        return dto;
    }
}
