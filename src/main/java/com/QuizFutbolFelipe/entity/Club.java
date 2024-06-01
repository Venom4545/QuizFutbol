package com.QuizFutbolFelipe.entity;
import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nombre;

    @OneToOne
    @JoinColumn(name = "entrenadores_id")
    private Entrenadores entrenadores;

    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores;

    @ManyToOne
    @JoinColumn(name = "asociacion_id")
    private Asociacion asociacion;

  
    

    // Getters and Setters
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

    public Entrenadores getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Entrenadores entrenadores) {
        this.entrenadores = entrenadores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    
}