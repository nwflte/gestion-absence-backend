package com.ensa.absence.service;

import java.util.List;
import java.util.Optional;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.payload.FiliereResponse;

public interface FiliereService {

	Filiere saveFiliere(Filiere filiere);
	Optional<Filiere> getFiliereById(Long id);
	Filiere archiverFiliere(Filiere filiere);
	List<Filiere> getAllFilieres();
	List<FiliereResponse> getAllFilieresResponse();
	FiliereResponse getFiliereResponse(Long id);
}
