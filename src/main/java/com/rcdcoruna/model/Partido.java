package com.rcdcoruna.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partidos")
public class Partido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "equipo_local_id", nullable = false)
    private Equipo equipoLocal;
    
    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id", nullable = false)
    private Equipo equipoVisitante;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "goles_local")
    private Integer golesLocal;
    
    @Column(name = "goles_visitante")
    private Integer golesVisitante;
    
    @Column(name = "estadio")
    private String estadio;
    
    @Column(name = "competicion")
    private String competicion;
    
    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<Participacion> participaciones;
    
    public Partido() {}
    
    public Partido(Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha, 
                   Integer golesLocal, Integer golesVisitante, String estadio, String competicion) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.estadio = estadio;
        this.competicion = competicion;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public Integer getGolesLocal() {
        return golesLocal;
    }
    
    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }
    
    public Integer getGolesVisitante() {
        return golesVisitante;
    }
    
    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
    public String getEstadio() {
        return estadio;
    }
    
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    
    public String getCompeticion() {
        return competicion;
    }
    
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }
    
    public List<Participacion> getParticipaciones() {
        return participaciones;
    }
    
    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
}
