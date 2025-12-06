package com.rcdcoruna.service;

import com.rcdcoruna.dto.ParticipacionDTO;
import com.rcdcoruna.model.Participacion;
import com.rcdcoruna.repository.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipacionService {

    @Autowired
    private ParticipacionRepository participacionRepository;

    public List<ParticipacionDTO> obtenerTodas() {
        return participacionRepository.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    public Optional<ParticipacionDTO> obtenerPorId(Integer id) {
        Optional<Participacion> participacion = participacionRepository.findById(id);
        return participacion.map(this::convertirADTO);
    }

    public ParticipacionDTO crear(Participacion participacion) {
        Participacion guardada = participacionRepository.save(participacion);
        return convertirADTO(guardada);
    }

    public ParticipacionDTO actualizar(Integer id, Participacion participacion) {
        Optional<Participacion> existente = participacionRepository.findById(id);
        if (existente.isPresent()) {
            participacion.setId(id);
            Participacion actualizada = participacionRepository.save(participacion);
            return convertirADTO(actualizada);
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

    public List<ParticipacionDTO> obtenerPorJugador(Integer jugadorId) {
        return participacionRepository.findByJugadorId(jugadorId).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    public List<ParticipacionDTO> obtenerPorPartido(Integer partidoId) {
        return participacionRepository.findByPartidoId(partidoId).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    public List<ParticipacionDTO> obtenerParticipacionesConGoles() {
        return participacionRepository.buscarParticipacionesConGoles().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    private ParticipacionDTO convertirADTO(Participacion p) {
        ParticipacionDTO dto = new ParticipacionDTO();
        dto.setId(p.getId());
        dto.setJugadorId(p.getJugador() != null ? p.getJugador().getId() : null);
        dto.setJugadorNombre(p.getJugador() != null ? p.getJugador().getNombre() : null);
        dto.setPartidoId(p.getPartido() != null ? p.getPartido().getId() : null);
        dto.setGoles(p.getGoles());
        dto.setAsistencias(p.getAsistencias());
        dto.setTarjetaAmarilla(p.getTarjetaAmarilla());
        dto.setTarjetaRoja(p.getTarjetaRoja());
        dto.setMinutosJugados(p.getMinutosJugados());
        return dto;
    }
}
