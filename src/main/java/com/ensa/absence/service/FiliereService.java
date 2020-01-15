package com.ensa.absence.service;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.payload.CreateFiliereRequest;
import com.ensa.absence.payload.FiliereResponse;

import java.util.List;
import java.util.Optional;

public interface FiliereService {

	Filiere saveFiliere(Filiere filiere);
	FiliereResponse saveFiliere(CreateFiliereRequest filiere);
	Optional<Filiere> getFiliereById(Long id);
	Filiere archiverFiliere(Filiere filiere);
	List<Filiere> getAllFilieres();
	List<FiliereResponse> getAllFilieresResponse();
	FiliereResponse getFiliereResponse(Long id);
}
