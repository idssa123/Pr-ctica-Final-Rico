package com.rcdcoruna.controller;

import com.rcdcoruna.dto.EquipoDTO;
import com.rcdcoruna.model.Equipo;
import com.rcdcoruna.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    
    @Autowired
    private EquipoService equipoService;
    
    @GetMapping
    public ResponseEntity<List<EquipoDTO>> obtenerTodos() {
        List<EquipoDTO> equipos = equipoService.obtenerTodos();
        return ResponseEntity.ok(equipos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> obtenerPorId(@PathVariable Integer id) {
        Optional<EquipoDTO> equipo = equipoService.obtenerPorId(id);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<EquipoDTO> crear(@RequestBody Equipo equipo) {
        EquipoDTO equipoCreado = equipoService.crear(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoCreado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EquipoDTO> actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        EquipoDTO equipoActualizado = equipoService.actualizar(id, equipo);
        if (equipoActualizado != null) {
            return ResponseEntity.ok(equipoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (equipoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<List<EquipoDTO>> obtenerPorCiudad(@PathVariable String ciudad) {
        List<EquipoDTO> equipos = equipoService.buscarPorCiudad(ciudad);
        return ResponseEntity.ok(equipos);
    }
}
