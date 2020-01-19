package com.ensa.absence.service;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.payload.CreateFiliereRequest;
import com.ensa.absence.payload.FiliereResponse;

import java.util.List;

public interface FiliereService {

	Filiere saveFiliere(Filiere filiere);
	FiliereResponse saveFiliere(CreateFiliereRequest filiere);
	List<Filiere> getAllFilieres();
	List<FiliereResponse> getAllFilieresResponse();
	FiliereResponse getFiliereResponse(Long id);
}
