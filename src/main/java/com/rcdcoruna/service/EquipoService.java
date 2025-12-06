package com.rcdcoruna.service;

import com.rcdcoruna.dto.EquipoDTO;
import com.rcdcoruna.model.Equipo;
import com.rcdcoruna.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoService {
    
    @Autowired
    private EquipoRepository equipoRepository;
    
    public List<EquipoDTO> obtenerTodos() {
        return equipoRepository.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    public Optional<EquipoDTO> obtenerPorId(Integer id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.map(this::convertirADTO);
    }
    
    public EquipoDTO crear(Equipo equipo) {
        Equipo guardado = equipoRepository.save(equipo);
        return convertirADTO(guardado);
    }
    
    public EquipoDTO actualizar(Integer id, Equipo equipo) {
        Optional<Equipo> existente = equipoRepository.findById(id);
        if (existente.isPresent()) {
            equipo.setId(id);
            Equipo actualizado = equipoRepository.save(equipo);
            return convertirADTO(actualizado);
        }
        return null;
    }
    
    public boolean eliminar(Integer id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<EquipoDTO> buscarPorCiudad(String ciudad) {
        return equipoRepository.findByCiudad(ciudad).stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }
    
    private EquipoDTO convertirADTO(Equipo equipo) {
        EquipoDTO dto = new EquipoDTO();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setCiudad(equipo.getCiudad());
        dto.setAñoFundacion(equipo.getAñoFundacion());
        dto.setEstadio(equipo.getEstadio());
        dto.setTotalJugadores(equipo.getJugadores() != null ? equipo.getJugadores().size() : 0);
        return dto;
    }
}
