package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Professeur;

import java.util.Optional;

public interface ProfesseurRepository extends BaseRepository<Professeur, Long> {

    Optional<Professeur> findByUser_Id(Long id);

    boolean existsByUser_Username(String username);

    Professeur findByUser_Username(String username);
}
