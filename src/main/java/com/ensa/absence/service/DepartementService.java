package com.ensa.absence.service;

import com.ensa.absence.domain.entity.Departement;

import java.util.List;

public interface DepartementService {

	Departement saveDepartement(Departement departement);
	List<Departement> getAllDepartements();
}
