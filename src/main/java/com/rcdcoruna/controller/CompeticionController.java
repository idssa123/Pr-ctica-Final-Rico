package com.rcdcoruna.controller;

import com.rcdcoruna.model.Competicion;
import com.rcdcoruna.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competiciones")
public class CompeticionController {
    
    @Autowired
    private CompeticionRepository competicionRepository;
    
    @GetMapping
    public ResponseEntity<List<Competicion>> obtenerTodas() {
        List<Competicion> competiciones = competicionRepository.findAll();
        return ResponseEntity.ok(competiciones);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Competicion> obtenerPorId(@PathVariable Integer id) {
        Optional<Competicion> competicion = competicionRepository.findById(id);
        return competicion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Competicion> crear(@RequestBody Competicion competicion) {
        Competicion competicionCreada = competicionRepository.save(competicion);
        return ResponseEntity.status(HttpStatus.CREATED).body(competicionCreada);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Competicion> actualizar(@PathVariable Integer id, @RequestBody Competicion competicion) {
        if (competicionRepository.existsById(id)) {
            competicion.setId(id);
            Competicion competicionActualizada = competicionRepository.save(competicion);
            return ResponseEntity.ok(competicionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (competicionRepository.existsById(id)) {
            competicionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Competicion> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Competicion> competicion = competicionRepository.findByNombre(nombre);
        return competicion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Competicion>> obtenerPorTipo(@PathVariable String tipo) {
        List<Competicion> competiciones = competicionRepository.findByTipo(tipo);
        return ResponseEntity.ok(competiciones);
    }
    
    @GetMapping("/año/{año}")
    public ResponseEntity<List<Competicion>> obtenerPorAño(@PathVariable Integer año) {
        List<Competicion> competiciones = competicionRepository.findByAño(año);
        return ResponseEntity.ok(competiciones);
    }
}
