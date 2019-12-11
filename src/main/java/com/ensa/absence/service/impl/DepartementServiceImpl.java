package com.ensa.absence.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Departement;
import com.ensa.absence.repository.DepartementRepository;
import com.ensa.absence.service.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService {
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@Override
	public Departement saveDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Optional<Departement> getDepartementById(Departement departement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departement archiverDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return null;
	}

}
