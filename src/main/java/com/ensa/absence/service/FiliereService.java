package com.ensa.absence.service;

import java.util.Optional;

import com.ensa.absence.domain.entity.Filiere;

public interface FiliereService {

	Filiere saveFiliere(Filiere filiere);
	Optional<Filiere> getFiliereById(Long id);
	Filiere archiverFiliere(Filiere filiere);

}
