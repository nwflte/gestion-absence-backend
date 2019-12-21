package com.ensa.absence.service;

import java.util.List;
import java.util.Optional;

import com.ensa.absence.domain.entity.Departement;

public interface DepartementService {

	Departement saveDepartement(Departement departement);
	Optional<Departement> getDepartementById(Departement departement);
	Departement archiverDepartement(Departement departement);
	List<Departement> getAllDepartements();
}
