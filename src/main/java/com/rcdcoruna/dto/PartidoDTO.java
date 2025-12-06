package com.rcdcoruna.dto;

import java.time.LocalDate;

public class PartidoDTO {
    
    private Integer id;
    private String equipoLocalNombre;
    private String equipoVisitanteNombre;
    private LocalDate fecha;
    private Integer golesLocal;
    private Integer golesVisitante;
    private String estadio;
    private String competicion;
    private String resultado;
    
    public PartidoDTO() {}
    
    public PartidoDTO(Integer id, String equipoLocalNombre, String equipoVisitanteNombre, 
                      LocalDate fecha, Integer golesLocal, Integer golesVisitante, 
                      String estadio, String competicion) {
        this.id = id;
        this.equipoLocalNombre = equipoLocalNombre;
        this.equipoVisitanteNombre = equipoVisitanteNombre;
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
    
    public String getEquipoLocalNombre() {
        return equipoLocalNombre;
    }
    
    public void setEquipoLocalNombre(String equipoLocalNombre) {
        this.equipoLocalNombre = equipoLocalNombre;
    }
    
    public String getEquipoVisitanteNombre() {
        return equipoVisitanteNombre;
    }
    
    public void setEquipoVisitanteNombre(String equipoVisitanteNombre) {
        this.equipoVisitanteNombre = equipoVisitanteNombre;
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
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
