package com.QuizFutbolFelipe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "entrenadores")


public class Entrenadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@NotBlank
	private String nombre;
    @NotBlank
	private String apellido;
    @NotNull
	private int edad;
    @NotBlank
	private String nacionalidad;

    
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    
}
