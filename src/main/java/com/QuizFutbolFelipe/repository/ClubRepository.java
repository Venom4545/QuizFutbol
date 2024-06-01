package com.QuizFutbolFelipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizFutbolFelipe.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Integer>{
    // Método para verificar si ya existe un club con el mismo entrenador
    boolean existsByEntrenadoresId(Integer entrenadoresId);

    // Método para verificar si ya existe un club con la misma asociación
    boolean existsByAsociacionId(Integer asociacionId);

}