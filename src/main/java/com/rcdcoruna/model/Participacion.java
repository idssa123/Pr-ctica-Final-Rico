package com.rcdcoruna.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participaciones")
public class Participacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;
    
    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;
    
    @Column(name = "goles")
    private Integer goles;
    
    @Column(name = "asistencias")
    private Integer asistencias;
    
    @Column(name = "tarjeta_amarilla")
    private Boolean tarjetaAmarilla;
    
    @Column(name = "tarjeta_roja")
    private Boolean tarjetaRoja;
    
    @Column(name = "minutos_jugados")
    private Integer minutosJugados;
    
    public Participacion() {}
    
    public Participacion(Jugador jugador, Partido partido, Integer goles, Integer asistencias, 
                         Boolean tarjetaAmarilla, Boolean tarjetaRoja, Integer minutosJugados) {
        this.jugador = jugador;
        this.partido = partido;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetaAmarilla = tarjetaAmarilla;
        this.tarjetaRoja = tarjetaRoja;
        this.minutosJugados = minutosJugados;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Jugador getJugador() {
        return jugador;
    }
    
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public Partido getPartido() {
        return partido;
    }
    
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public Integer getGoles() {
        return goles;
    }
    
    public void setGoles(Integer goles) {
        this.goles = goles;
    }
    
    public Integer getAsistencias() {
        return asistencias;
    }
    
    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }
    
    public Boolean getTarjetaAmarilla() {
        return tarjetaAmarilla;
    }
    
    public void setTarjetaAmarilla(Boolean tarjetaAmarilla) {
        this.tarjetaAmarilla = tarjetaAmarilla;
    }
    
    public Boolean getTarjetaRoja() {
        return tarjetaRoja;
    }
    
    public void setTarjetaRoja(Boolean tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }
    
    public Integer getMinutosJugados() {
        return minutosJugados;
    }
    
    public void setMinutosJugados(Integer minutosJugados) {
        this.minutosJugados = minutosJugados;
    }
}
