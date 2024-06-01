package com.QuizFutbolFelipe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="asociacion")
public class Asociacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String pais;
    @NotBlank
    private String presidente;
    @NotBlank
    private String siglas;


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
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getPresidente() {
        return presidente;
    }
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
    public String getSiglas() {
        return siglas;
    }
    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    
    

}
