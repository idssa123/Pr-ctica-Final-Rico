package com.rcdcoruna.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "competiciones")
public class Competicion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "año")
    private Integer año;
    
    @ManyToMany(mappedBy = "competiciones")
    private List<Jugador> jugadores;
    
    public Competicion() {}
    
    public Competicion(String nombre, String tipo, Integer año) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.año = año;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Integer getAño() {
        return año;
    }
    
    public void setAño(Integer año) {
        this.año = año;
    }
    
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
