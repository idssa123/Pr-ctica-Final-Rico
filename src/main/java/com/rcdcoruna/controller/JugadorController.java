package com.rcdcoruna.controller;

import com.rcdcoruna.dto.JugadorDTO;
import com.rcdcoruna.model.Jugador;
import com.rcdcoruna.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {
    
    @Autowired
    private JugadorService jugadorService;
    
    @GetMapping
    public ResponseEntity<List<JugadorDTO>> obtenerTodos() {
        List<JugadorDTO> jugadores = jugadorService.obtenerTodos();
        return ResponseEntity.ok(jugadores);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> obtenerPorId(@PathVariable Integer id) {
        Optional<JugadorDTO> jugador = jugadorService.obtenerPorId(id);
        return jugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<JugadorDTO> crear(@RequestBody Jugador jugador) {
        JugadorDTO jugadorCreado = jugadorService.crear(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jugadorCreado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JugadorDTO> actualizar(@PathVariable Integer id, @RequestBody Jugador jugador) {
        JugadorDTO jugadorActualizado = jugadorService.actualizar(id, jugador);
        if (jugadorActualizado != null) {
            return ResponseEntity.ok(jugadorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (jugadorService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<List<JugadorDTO>> obtenerPorEquipo(@PathVariable Integer equipoId) {
        List<JugadorDTO> jugadores = jugadorService.obtenerPorEquipo(equipoId);
        return ResponseEntity.ok(jugadores);
    }
    
    @GetMapping("/posicion/{posicion}")
    public ResponseEntity<List<JugadorDTO>> obtenerPorPosicion(@PathVariable String posicion) {
        List<JugadorDTO> jugadores = jugadorService.obtenerPorPosicion(posicion);
        return ResponseEntity.ok(jugadores);
    }
}
