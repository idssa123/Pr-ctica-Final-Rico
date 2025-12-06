package com.rcdcoruna.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "numero_camiseta")
    private Integer numeroCamiseta;
    
    @Column(name = "posicion")
    private String posicion;
    
    @Column(name = "altura")
    private Double altura;
    
    @Column(name = "peso")
    private Integer peso;
    
    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "jugador_competicion",
        joinColumns = @JoinColumn(name = "jugador_id"),
        inverseJoinColumns = @JoinColumn(name = "competicion_id")
    )
    private List<Competicion> competiciones;
    
    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<Participacion> participaciones;
    
    public Jugador() {}
    
    public Jugador(String nombre, Integer numeroCamiseta, String posicion, Double altura, Integer peso, Equipo equipo) {
        this.nombre = nombre;
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
        this.altura = altura;
        this.peso = peso;
        this.equipo = equipo;
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
    
    public Integer getNumeroCamiseta() {
        return numeroCamiseta;
    }
    
    public void setNumeroCamiseta(Integer numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }
    
    public String getPosicion() {
        return posicion;
    }
    
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    public Double getAltura() {
        return altura;
    }
    
    public void setAltura(Double altura) {
        this.altura = altura;
    }
    
    public Integer getPeso() {
        return peso;
    }
    
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    
    public Equipo getEquipo() {
        return equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    public List<Competicion> getCompeticiones() {
        return competiciones;
    }
    
    public void setCompeticiones(List<Competicion> competiciones) {
        this.competiciones = competiciones;
    }
    
    public List<Participacion> getParticipaciones() {
        return participaciones;
    }
    
    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
}
