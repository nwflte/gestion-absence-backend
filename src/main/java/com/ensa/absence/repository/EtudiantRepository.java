package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.AppUtilisateur;
import com.ensa.absence.domain.entity.Etudiant;

public interface EtudiantRepository extends BaseRepository<Etudiant, Long> {

    boolean existsByUser_Username(String username);

    Etudiant findByUser_Username(String username);
}
