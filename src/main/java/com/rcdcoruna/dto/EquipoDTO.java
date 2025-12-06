package com.rcdcoruna.dto;

public class EquipoDTO {
    
    private Integer id;
    private String nombre;
    private String ciudad;
    private Integer añoFundacion;
    private String estadio;
    private Integer totalJugadores;
    
    public EquipoDTO() {}
    
    public EquipoDTO(Integer id, String nombre, String ciudad, Integer añoFundacion, String estadio) {
        this.id = id;
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
    
    public Integer getTotalJugadores() {
        return totalJugadores;
    }
    
    public void setTotalJugadores(Integer totalJugadores) {
        this.totalJugadores = totalJugadores;
    }
}
