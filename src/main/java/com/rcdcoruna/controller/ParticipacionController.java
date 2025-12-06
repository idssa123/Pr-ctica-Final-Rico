package com.rcdcoruna.controller;

import com.rcdcoruna.dto.ParticipacionDTO;
import com.rcdcoruna.model.Participacion;
import com.rcdcoruna.service.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participaciones")
public class ParticipacionController {
    
    @Autowired
    private ParticipacionService participacionService;
    
    @GetMapping
    public ResponseEntity<List<ParticipacionDTO>> obtenerTodas() {
        List<ParticipacionDTO> participaciones = participacionService.obtenerTodas();
        return ResponseEntity.ok(participaciones);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ParticipacionDTO> obtenerPorId(@PathVariable Integer id) {
        Optional<ParticipacionDTO> participacion = participacionService.obtenerPorId(id);
        return participacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<ParticipacionDTO> crear(@RequestBody Participacion participacion) {
        ParticipacionDTO participacionCreada = participacionService.crear(participacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(participacionCreada);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ParticipacionDTO> actualizar(@PathVariable Integer id, @RequestBody Participacion participacion) {
        ParticipacionDTO participacionActualizada = participacionService.actualizar(id, participacion);
        if (participacionActualizada != null) {
            return ResponseEntity.ok(participacionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (participacionService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/jugador/{jugadorId}")
    public ResponseEntity<List<ParticipacionDTO>> obtenerPorJugador(@PathVariable Integer jugadorId) {
        List<ParticipacionDTO> participaciones = participacionService.obtenerPorJugador(jugadorId);
        return ResponseEntity.ok(participaciones);
    }
    
    @GetMapping("/partido/{partidoId}")
    public ResponseEntity<List<ParticipacionDTO>> obtenerPorPartido(@PathVariable Integer partidoId) {
        List<ParticipacionDTO> participaciones = participacionService.obtenerPorPartido(partidoId);
        return ResponseEntity.ok(participaciones);
    }
    
    @GetMapping("/con-goles")
    public ResponseEntity<List<ParticipacionDTO>> obtenerParticipacionesConGoles() {
        List<ParticipacionDTO> participaciones = participacionService.obtenerParticipacionesConGoles();
        return ResponseEntity.ok(participaciones);
    }
}
