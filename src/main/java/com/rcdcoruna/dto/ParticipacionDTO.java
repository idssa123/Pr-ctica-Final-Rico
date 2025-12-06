package com.rcdcoruna.dto;

public class ParticipacionDTO {
    
    private Integer id;
    private Integer jugadorId;
    private String jugadorNombre;
    private Integer partidoId;
    private Integer goles;
    private Integer asistencias;
    private Boolean tarjetaAmarilla;
    private Boolean tarjetaRoja;
    private Integer minutosJugados;
    
    public ParticipacionDTO() {}
    
    public ParticipacionDTO(Integer id, Integer jugadorId, String jugadorNombre, Integer partidoId,
                           Integer goles, Integer asistencias, Boolean tarjetaAmarilla, 
                           Boolean tarjetaRoja, Integer minutosJugados) {
        this.id = id;
        this.jugadorId = jugadorId;
        this.jugadorNombre = jugadorNombre;
        this.partidoId = partidoId;
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
    
    public Integer getJugadorId() {
        return jugadorId;
    }
    
    public void setJugadorId(Integer jugadorId) {
        this.jugadorId = jugadorId;
    }
    
    public String getJugadorNombre() {
        return jugadorNombre;
    }
    
    public void setJugadorNombre(String jugadorNombre) {
        this.jugadorNombre = jugadorNombre;
    }
    
    public Integer getPartidoId() {
        return partidoId;
    }
    
    public void setPartidoId(Integer partidoId) {
        this.partidoId = partidoId;
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
