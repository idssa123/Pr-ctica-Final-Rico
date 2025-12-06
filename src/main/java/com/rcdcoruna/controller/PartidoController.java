package com.rcdcoruna.controller;

import com.rcdcoruna.dto.PartidoDTO;
import com.rcdcoruna.model.Partido;
import com.rcdcoruna.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {
    
    @Autowired
    private PartidoService partidoService;
    
    @GetMapping
    public ResponseEntity<List<PartidoDTO>> obtenerTodos() {
        List<PartidoDTO> partidos = partidoService.obtenerTodos();
        return ResponseEntity.ok(partidos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PartidoDTO> obtenerPorId(@PathVariable Integer id) {
        Optional<PartidoDTO> partido = partidoService.obtenerPorId(id);
        return partido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<PartidoDTO> crear(@RequestBody Partido partido) {
        PartidoDTO partidoCreado = partidoService.crear(partido);
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoCreado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PartidoDTO> actualizar(@PathVariable Integer id, @RequestBody Partido partido) {
        PartidoDTO partidoActualizado = partidoService.actualizar(id, partido);
        if (partidoActualizado != null) {
            return ResponseEntity.ok(partidoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (partidoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<List<PartidoDTO>> obtenerPorEquipo(@PathVariable Integer equipoId) {
        List<PartidoDTO> partidos = partidoService.obtenerPorEquipo(equipoId);
        return ResponseEntity.ok(partidos);
    }
    
    @GetMapping("/competicion/{competicion}")
    public ResponseEntity<List<PartidoDTO>> obtenerPorCompeticion(@PathVariable String competicion) {
        List<PartidoDTO> partidos = partidoService.obtenerPorCompeticion(competicion);
        return ResponseEntity.ok(partidos);
    }
}
