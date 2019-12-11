package com.ensa.absence.service;

import java.util.Optional;

import com.ensa.absence.domain.entity.Professeur;

public interface ProfesseurService {
	
	Optional<Professeur> getProfesseurById(Long id);
	Professeur saveProfesseur(Professeur professeur);
	Professeur archiverProfesseur(Professeur professeur);

}
