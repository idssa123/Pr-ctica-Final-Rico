package com.rcdcoruna.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "año_fundacion")
    private Integer añoFundacion;
    
    @Column(name = "estadio")
    private String estadio;
    
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;
    
    public Equipo() {}
    
    public Equipo(String nombre, String ciudad, Integer añoFundacion, String estadio) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.añoFundacion = añoFundacion;
        this.estadio = estadio;
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
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public Integer getAñoFundacion() {
        return añoFundacion;
    }
    
    public void setAñoFundacion(Integer añoFundacion) {
        this.añoFundacion = añoFundacion;
    }
    
    public String getEstadio() {
        return estadio;
    }
    
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
