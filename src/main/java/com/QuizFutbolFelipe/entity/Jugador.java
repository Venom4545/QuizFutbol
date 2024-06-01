package com.QuizFutbolFelipe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nombre;

    @NotNull
    private String numero;

    @NotNull
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    // Getter y Setter para el atributo club
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    // Getter y Setter para los demás atributos
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}

