package com.ensa.absence.repository;

import java.util.Optional;

import com.ensa.absence.domain.entity.AppUtilisateur;
import com.ensa.absence.domain.entity.Professeur;

public interface ProfesseurRepository extends BaseRepository<Professeur, Long> {

	Optional<Professeur> findByUser_Id(Long id);

    boolean existsByUser_Username(String username);

    Professeur findByUser_Username(String username);
}
