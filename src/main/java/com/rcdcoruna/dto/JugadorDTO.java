package com.rcdcoruna.dto;

public class JugadorDTO {
    
    private Integer id;
    private String nombre;
    private Integer numeroCamiseta;
    private String posicion;
    private Double altura;
    private Integer peso;
    private String nombreEquipo;
    private Integer equipoId;
    private Integer totalGoles;
    
    public JugadorDTO() {}
    
    public JugadorDTO(Integer id, String nombre, Integer numeroCamiseta, String posicion, 
                      Double altura, Integer peso, String nombreEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
        this.altura = altura;
        this.peso = peso;
        this.nombreEquipo = nombreEquipo;
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
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    
    public Integer getEquipoId() {
        return equipoId;
    }
    
    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }
    
    public Integer getTotalGoles() {
        return totalGoles;
    }
    
    public void setTotalGoles(Integer totalGoles) {
        this.totalGoles = totalGoles;
    }
}
